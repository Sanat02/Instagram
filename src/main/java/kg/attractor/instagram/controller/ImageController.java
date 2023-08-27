package kg.attractor.instagram.controller;


import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.ProfileImageService;
import kg.attractor.instagram.service.ProfilePhotoService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class ImageController {

    private final ProfileImageService profileImageService;
    private final ProfilePhotoService profilePhotoService;
    private final UserService userService;

    @GetMapping("/download/{imageId}")
    public ResponseEntity<?> downloadImage(@PathVariable int imageId) {
        return profileImageService.downloadImage(imageId);
    }

    @PostMapping("/upload")
    public HttpStatus uploadImage(ProfileImageDto profileImageDto) {
        profileImageService.uploadImage(profileImageDto);
        return HttpStatus.OK;

    }

    @GetMapping("/{imageId}")
    public ResponseEntity<?> getImagesByUserId(@PathVariable int imageId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return profileImageService.getImageByUsId(imageId,userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId());
    }
    @GetMapping("/photo")
    public ResponseEntity<?> getPhotoByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        return profilePhotoService.getImageByUsId(userDto.getId()) ;
    }
}
