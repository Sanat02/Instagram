package kg.attractor.instagram.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FollowerDto {
    private int id;
    private  UserDto user;
    private UserDto follower;
}
