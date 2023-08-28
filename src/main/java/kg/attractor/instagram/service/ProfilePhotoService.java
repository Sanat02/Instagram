package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.ProfilePhotoDao;
import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.model.ProfileImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfilePhotoService {
    private static final String SUB_DIR = "/images";
    private final ProfilePhotoDao profilePhotoDao;
    private final FileService fileService;

    public void uploadImage(ProfileImageDto profileImageDto) {
        String fileName = fileService.saveUploadedFile(profileImageDto.getFile(), SUB_DIR);
        ProfileImage pi = ProfileImage.builder()
                .userId(profileImageDto.getUserId())
                .fileName(fileName)
                .id(profileImageDto.getId())
                .build();
        profilePhotoDao.save(pi);
        log.info("Image saved:" + pi.getFileName());

    }

    public ResponseEntity<?> getImageByUsId(int userId) {
        ProfileImage image = profilePhotoDao.getImageByUserId(userId);
        if (image != null) {
            return fileService.getOutputFile(image.getFileName(), SUB_DIR, MediaType.IMAGE_JPEG);
        }else{
            return null;
        }
    }

    public ProfileImageDto getImageByUserId(int userId) {
        ProfileImage image = profilePhotoDao.getImageByUserId(userId);
        if (image != null) {
            return ProfileImageDto.builder()
                    .id(image.getId())
                    .userId(userId)
                    .fileName(image.getFileName())
                    .build();
        } else {
            return null;
        }
    }

    public void deletePhoto(int userId) {
        profilePhotoDao.delete(userId);
    }
}
