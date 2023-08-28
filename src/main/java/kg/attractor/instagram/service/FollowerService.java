package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.FollowerDao;
import kg.attractor.instagram.dto.FollowerDto;
import kg.attractor.instagram.model.Follower;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowerService {
    private final FollowerDao followerDao;

    public void saveFollower(FollowerDto followerDto) {
        followerDao.save(Follower.builder()
                .followerId(followerDto.getFollowerId())
                .userId(followerDto.getUserId())
                .build()
        );
    }
    public boolean isFollow(int userId,int followerId){
        return followerDao.isFollow(userId,followerId);
    }
    public void unfollow(int userId,int followerId){
         followerDao.deleteById(userId,followerId);
    }
}
