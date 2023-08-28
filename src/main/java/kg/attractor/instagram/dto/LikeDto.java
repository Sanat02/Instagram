package kg.attractor.instagram.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LikeDto {
    private int id;
    private UserDto user;
    private ProfileImageDto profileImage;
}
