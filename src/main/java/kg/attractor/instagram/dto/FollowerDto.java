package kg.attractor.instagram.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FollowerDto {
    private int id;
    private  int userId;
    private int followerId;
}
