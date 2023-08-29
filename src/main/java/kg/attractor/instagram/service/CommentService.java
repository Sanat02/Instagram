package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.CommentDao;
import kg.attractor.instagram.dto.CommentDto;
import kg.attractor.instagram.model.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentDao commentDao;
    private final UserService userService;

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

    public List<CommentDto> getCommentsByImageId(int imageId) {
        List<Comment> comments = commentDao.getCommentsByImageId(imageId);
        return comments.stream()
                .map(e -> CommentDto.builder()
                        .id(e.getId())
                        .userId(e.getUserId())
                        .followerId(e.getFollowerId())
                        .comment(e.getComment())
                        .commentDate(e.getCommentDate())
                        .senderName(userService.getUserById(e.getUserId()).get().getAccountName())
                        .build()
                ).collect(Collectors.toList());
    }
}
