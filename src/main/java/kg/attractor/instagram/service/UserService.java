package kg.attractor.instagram.service;

import kg.attractor.instagram.dao.UserDao;
import kg.attractor.instagram.dto.UserDto;
import kg.attractor.instagram.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;
    private final ProfileImageService profileImageService;


    public List<UserDto> getAllUsers() {
        log.info("Gol all users");
        List<User> users = userDao.getAllUsers();
        List<UserDto> userDtos = users.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .fullName(e.getFullName())
                        .password(e.getPassword())
                        .email(e.getEmail())
                        .accountName(e.getAccountName())
                        .build()
                ).collect(Collectors.toList());

        return userDtos;
    }


    public Optional<User> getUserByEmail(String email) {
        log.info("Gol user by email:" + email);
        Optional<User> mayBeUser = userDao.getUserByEmail(email);
        return mayBeUser;
    }

    public String isUserExist(String email) {
        try {

            Optional<User> user = userDao.getUserByEmail(email);
            if (user.isPresent()) {
                log.error("User:" + email + "  exists!");
                return "1";
            } else {
                log.info("User:" + email + " does not exist!");
                return "0";
            }
        } catch (EmptyResultDataAccessException e) {
            log.error("Empty Result!");
            return "error";
        }
    }


    public Optional<User> getUserById(int id) {
        log.info("Got user by id:" + id);
        return userDao.getUserById(id);
    }


    public int save(UserDto userDto) {
        log.info("The user:" + userDto.getEmail() + " is saved!");
        return userDao.save(User.builder()
                .accountName(userDto.getAccountName())
                .fullName(userDto.getFullName())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .enabled(true)
                .roleId(1)
                .build());

    }

    public void update(UserDto userDto) {
        log.info("The user:" + userDto.getEmail() + " is updated!");
        userDao.update(User.builder()
                .accountName(userDto.getAccountName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .fullName(userDto.getFullName())
                .id(userDto.getId())
                .build());
    }

    public UserDto mapToUserDto(User user) {
        if (user != null) {
            return UserDto.builder()
                    .id(user.getId())
                    .accountName(user.getAccountName())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .images(profileImageService.getImageByUserId(user.getId()))
                    .build();
        } else {
            return null;
        }
    }
}
