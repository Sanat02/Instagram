package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.FollowerService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FollowerService followerService;

    @GetMapping()
    public String getUsers(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        model.addAttribute("account", userDto);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{userId}")
    public String getUserProfile(@PathVariable int userId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto followerDto = userService.mapToUserDto(userService.getUserById(userId).orElse(null));
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        model.addAttribute("account", followerDto);
        model.addAttribute("user", userDto);

        if (userDto != null) {
           model.addAttribute("isFollower",followerService.isFollow(userDto.getId(),followerDto.getId()));
        }
        return "userProfile";
    }

}
