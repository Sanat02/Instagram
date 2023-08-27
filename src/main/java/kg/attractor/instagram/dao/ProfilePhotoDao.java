package kg.attractor.instagram.dao;

import kg.attractor.instagram.model.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfilePhotoDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(ProfileImage profileImage) {
        String sql = "insert into profile_photo(userid,filename) " +
                "values  ( ? , ? )";
        jdbcTemplate.update(sql, profileImage.getUserId(), profileImage.getFileName());
    }

    public ProfileImage getImageByUserId(int userId) {
        String sql = "select * from profile_photo where userId = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProfileImage.class), userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void delete(int userId) {
        String sql = "DELETE FROM profile_photo WHERE userId = ?";
        jdbcTemplate.update(sql, userId);
    }

}
