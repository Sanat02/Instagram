package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.FollowerDto;
import kg.attractor.instagram.dto.LikeDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.LikeService;
import kg.attractor.instagram.service.ProfileImageService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@Slf4j
public class LikeController {
    private final LikeService likeService;
    private final UserService userService;
    private final ProfileImageService profileImageService;

    @GetMapping("/{imageId}")
    public void like(@PathVariable int imageId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        likeService.saveLike(LikeDto.builder()
                .user(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()))
                .profileImage(profileImageService.getImageById(imageId))
                .build());
    }
    @DeleteMapping("/{imageId}")
    public void unLike(@PathVariable int imageId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        likeService.unLike(imageId,userDto.getId());
    }

}
