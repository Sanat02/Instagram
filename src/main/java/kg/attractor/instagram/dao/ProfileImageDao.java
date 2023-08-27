package kg.attractor.instagram.dao;


import kg.attractor.instagram.model.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfileImageDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(ProfileImage profileImage) {
        String sql = "insert into profile_images(userid,filename) " +
                "values  ( ? , ? )";
        jdbcTemplate.update(sql, profileImage.getUserId(), profileImage.getFileName());
    }

    public ProfileImage getImageById(int imageId) {
        String sql = "select * from profile_images where id = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileImage.class), imageId));
    }

    public ProfileImage getImageByUserIdAndId(int imageId,int userId) {
        String sql = "select * from profile_images where userId = ? and id=?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileImage.class), userId,imageId));
    }
    public List<ProfileImage> getImageByUserId(int userId) {
        String sql = "select * from profile_images where userId = ? ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileImage.class), userId);
    }
}
