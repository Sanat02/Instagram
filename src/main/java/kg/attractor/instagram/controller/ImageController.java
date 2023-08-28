package kg.attractor.instagram.controller;


import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.ProfileImageService;
import kg.attractor.instagram.service.ProfilePhotoService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
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
    public ResponseEntity<?> getImages(@PathVariable int imageId) {
        System.out.println("IMAGE ID:" + imageId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return profileImageService.getImageByUsId(imageId, userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId());
    }

    @GetMapping("/{imageId}/{userId}")
    public ResponseEntity<?> getImagesByUserId(@PathVariable int imageId, @PathVariable int userId) {
        return profileImageService.getImageByUsId(imageId, userId);
    }


    @GetMapping("/photo")
    public ResponseEntity<?> getPhoto() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        return profilePhotoService.getImageByUsId(userDto.getId());
    }

    @GetMapping("/photo/{userId}")
    public ResponseEntity<?> getPhotoByUserId(@PathVariable int userId) {
        return profilePhotoService.getImageByUsId(userId);
    }
}
