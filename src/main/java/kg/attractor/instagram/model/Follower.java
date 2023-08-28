package kg.attractor.instagram.model;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Follower {
    private int id;
    private  int userId;
    private int followerId;
}
