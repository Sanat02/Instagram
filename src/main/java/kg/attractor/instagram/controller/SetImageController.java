package kg.attractor.instagram.controller;


import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.service.ProfileImageService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/images")
@Controller
public class SetImageController {
    private final ProfileImageService profileImageService;
    private final UserService userService;

    @GetMapping()
    public String setImage(Model model) {
        return "setImage";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String addImage(
            @RequestParam(name = "files") MultipartFile image

    ) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        ProfileImageDto profileImageDto=ProfileImageDto.builder()
                .file(image)
                .userId(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId())
                .build();
        profileImageService.uploadImage(profileImageDto);
        return "redirect:/profile" ;
    }

}
