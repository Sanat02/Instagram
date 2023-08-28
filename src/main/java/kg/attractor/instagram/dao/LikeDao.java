package kg.attractor.instagram.dao;

import kg.attractor.instagram.model.Follower;
import kg.attractor.instagram.model.Like;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Component
public class LikeDao extends BaseDao {
    LikeDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public int save(Object obj) {
        Like like = (Like) obj;
        String sql = "INSERT INTO likes (userId,imageId) " +
                "VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setInt(1, like.getUserId());
            ps.setInt(2, like.getImageId());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();

    }

    public boolean isFollow(int userId, int imageId) {
        String sql = "SELECT COUNT(*) FROM likes WHERE userId = ? AND imageId = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, imageId);
        return count > 0;
    }

    @Override
    public void delete(int id) {


    }

    public void deleteLike(int imageId, int userId) {
        String sql = "DELETE FROM likes WHERE imageId = ? and userId = ? ";
        jdbcTemplate.update(sql, imageId, userId);
    }

    @Override
    public void update(Object obj) {

    }

    public List<Like> getLikesById(int imageId) {
        String sql = "SELECT * FROM LIKES WHERE imageId=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class), imageId);
    }
}
