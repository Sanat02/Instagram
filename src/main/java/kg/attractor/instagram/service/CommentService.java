package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.CommentDao;
import kg.attractor.instagram.dto.CommentDto;
import kg.attractor.instagram.model.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentDao commentDao;

    public void saveComment(CommentDto commentDto) {
        commentDao.save(Comment.builder()
                .userId(commentDto.getUserId())
                .followerId(commentDto.getFollowerId())
                .imageId(commentDto.getImageId())
                .comment(commentDto.getComment())
                .commentDate(LocalDate.now())
                .build()
        );
    }
}
