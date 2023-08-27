package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.ProfileImageDao;
import kg.attractor.instagram.dto.ProfileImageDto;
import kg.attractor.instagram.model.ProfileImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileImageService {
    private static final String SUB_DIR = "/images";
    private final FileService fileService;
    private final ProfileImageDao profileImageDao;

    public void uploadImage(ProfileImageDto profileImageDto) {
        String fileName = fileService.saveUploadedFile(profileImageDto.getFile(), SUB_DIR);
        ProfileImage pi = ProfileImage.builder()
                .userId(profileImageDto.getUserId())
                .fileName(fileName)
                .id(profileImageDto.getId())
                .build();
        profileImageDao.save(pi);
        log.info("Image saved:" + pi.getFileName());

    }

    public ResponseEntity<?> downloadImage(int imageId) {
        String filename;
        try {
            ProfileImage profileImage = profileImageDao.getImageById(imageId);
            filename = profileImage.getFileName();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Image not found!");
        }
        return fileService.getOutputFile(filename, "/images", MediaType.IMAGE_PNG);
    }

    public List<ProfileImageDto> getImageByUserId(int userId) {
        List<ProfileImage> profileImages = profileImageDao.getImageByUserId(userId);
        List<ProfileImageDto> profileImageDtos = profileImages.stream()
                .map(e -> ProfileImageDto.builder()
                        .id(e.getId())
                        .fileName(e.getFileName())
                        .userId(e.getUserId())
                        .build()
                ).collect(Collectors.toList());
        return profileImageDtos;
    }

    public ResponseEntity<?> getImageByUsId(int imageId,int userId) {
        ProfileImage image = profileImageDao.getImageByUserIdAndId(imageId,userId);
            return fileService.getOutputFile(image.getFileName(), SUB_DIR, MediaType.IMAGE_JPEG);
    }
}
