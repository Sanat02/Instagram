package kg.attractor.instagram.controller;



import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;

    @GetMapping("/profile")
    public String register(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        model.addAttribute("account",userDto);
        return "profile";
    }

}
