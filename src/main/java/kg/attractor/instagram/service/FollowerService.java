package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.FollowerDao;
import kg.attractor.instagram.dto.FollowerDto;
import kg.attractor.instagram.model.Follower;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowerService {
    private final FollowerDao followerDao;
    private final UserService userService;

    public void saveFollower(FollowerDto followerDto) {
        followerDao.save(Follower.builder()
                .followerId(followerDto.getFollower().getId())
                .userId(followerDto.getUser().getId())
                .build()
        );
    }

    public boolean isFollow(int userId, int followerId) {
        return followerDao.isFollow(userId, followerId);
    }

    public void unfollow(int userId, int followerId) {
        followerDao.deleteById(userId, followerId);
    }

    public List<FollowerDto> getFollowersByUserId(int userId) {
        List<Follower> followers = followerDao.getFollowersByUserId(userId);
        return followers.stream()
                .map(e -> FollowerDto.builder()
                        .follower(userService.mapToUserDto(userService.getUserById(e.getFollowerId()).orElse(null)))
                        .user(userService.mapToUserDto(userService.getUserById(e.getFollowerId()).orElse(null)))
                        .id(e.getId())
                        .build()
                ).collect(Collectors.toList());
    }
}
