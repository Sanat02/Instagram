package kg.attractor.instagram.controller;

import kg.attractor.instagram.dto.FollowerDto;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.service.FollowerService;
import kg.attractor.instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow/")
@RequiredArgsConstructor
public class FollowerController {
    private final UserService userService;
    private final FollowerService followerService;

    @GetMapping("/{followerId}")
    public void follow(@PathVariable int followerId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        followerService.saveFollower(FollowerDto.builder()
                .followerId(followerId)
                .userId(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId())
                .build());
    }

    @DeleteMapping("/{followerId}")
    public void unfollow(@PathVariable int followerId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        followerService.unfollow(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null)).getId(), followerId);
    }

}
