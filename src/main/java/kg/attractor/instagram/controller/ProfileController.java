package kg.attractor.instagram.controller;



import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.LikeService;
import kg.attractor.instagram.service.ProfileImageService;
import kg.attractor.instagram.service.ProfilePhotoService;
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
    private final ProfileImageService profileImageService;
    private final LikeService likeService;


    @GetMapping("/profile")
    public String getProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        model.addAttribute("account",userDto);
        return "profile";
    }

    @GetMapping("/profile/{imageId}")
    public String getPost(@PathVariable int imageId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        model.addAttribute("account",userDto);
        ProfileImageDto profileImageDto=profileImageService.getImageById(imageId);
        profileImageDto.setLikes(likeService.getLikesById(imageId));
        model.addAttribute("image",profileImageDto);
        return "post";
    }

}
