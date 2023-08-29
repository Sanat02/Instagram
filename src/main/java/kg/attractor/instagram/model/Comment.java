package kg.attractor.instagram.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Comment {
    private int id;
    private int userId;
    private int followerId;
    private int imageId;
    private String comment;
    private LocalDate commentDate;
}
