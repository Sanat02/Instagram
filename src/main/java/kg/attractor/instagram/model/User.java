package kg.attractor.instagram.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private int id;
    private String email;
    private String accountName;
    private String fullName;
    private String password;
    private int roleId;
    private boolean enabled;
}
