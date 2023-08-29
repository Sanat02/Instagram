package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.FollowerDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.FollowerService;
import kg.attractor.instagram.service.LikeService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor

public class HomeController {
    private final UserService userService;
    private final FollowerService followerService;
    private final LikeService likeService;


    @GetMapping
    public String getHomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        if (userDto != null) {
            List<FollowerDto> followers = followerService.getFollowersByUserId(userDto.getId());
            for (int i = 0; i < followers.size(); i++) {
                for (int j = 0; j < followers.get(i).getUser().getImages().size(); j++) {
                    followers.get(i).getUser().getImages().get(j).setLiked(likeService.isLike(userDto.getId(),
                            followers.get(i).getUser().getImages().get(j).getId()));
                    followers.get(i).getUser().getImages().get(j).setLikes(likeService.getLikesById(
                            followers.get(i).getUser().getImages().get(j).getId()));
                }
            }
            model.addAttribute("followers", followers);
        }
        model.addAttribute("account", userDto);

        return "home";
    }
}
