package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.LikeDao;
import kg.attractor.instagram.dto.LikeDto;
import kg.attractor.instagram.model.Like;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {
    private final LikeDao likeDao;

    public void saveLike(LikeDto likeDto) {
        likeDao.save(Like.builder()
                .userId(likeDto.getUser().getId())
                .imageId(likeDto.getProfileImage().getId())
                .build()
        );
    }

    public boolean isLike(int userId, int imageId) {
        return likeDao.isFollow(userId, imageId);
    }

    public void unLike(int imageId, int userId) {
        likeDao.deleteLike(imageId, userId);
    }

    public int getLikesById(int imageId) {
        return likeDao.getLikesById(imageId).size();
    }
}
