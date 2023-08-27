package kg.attractor.instagram.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class ProfileImageDto {
    private int id;
    private MultipartFile file;
    private String fileName;

    @Pattern(regexp = "^[0-9]+$", message = "User id should contain only numbers!")
    private int userId;
}
