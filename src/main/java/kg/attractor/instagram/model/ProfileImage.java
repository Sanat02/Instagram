package kg.attractor.instagram.model;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ProfileImage {
    private int id;
    private int userId;
    private String fileName;

}
