package kg.attractor.instagram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CommentDto {
    private int id;
    private int userId;
    private int followerId;
    private int imageId;
    private String comment;
    private LocalDate commentDate;
}
