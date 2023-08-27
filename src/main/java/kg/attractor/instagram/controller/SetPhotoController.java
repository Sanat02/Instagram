package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.model.ProfileImage;
import kg.attractor.instagram.service.ProfilePhotoService;
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
@RequestMapping("/photo")
@Controller
public class SetPhotoController {
    private final ProfilePhotoService profilePhotoService;
    private final UserService userService;

    @GetMapping()
    public String setImage(Model model) {
        return "setPhoto";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String addImage(
            @RequestParam(name = "files") MultipartFile image

    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ProfileImageDto profileImageDto = ProfileImageDto.builder()
                .file(image)
                .userId(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId())
                .build();
        if (profilePhotoService.getImageByUserId((userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId()))==null) {
            profilePhotoService.uploadImage(profileImageDto);
        }
        else{
            profilePhotoService.deletePhoto(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId());
            profilePhotoService.uploadImage(profileImageDto);
        }
        return "redirect:/profile";
    }
}
