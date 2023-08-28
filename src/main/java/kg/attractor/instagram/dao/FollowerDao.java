package kg.attractor.instagram.dao;

import kg.attractor.instagram.model.Follower;
import kg.attractor.instagram.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Objects;

@Component
public class FollowerDao extends BaseDao {
    FollowerDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public int save(Object obj) {
        Follower follower = (Follower) obj;
        String sql = "INSERT INTO followers (userId,followerId) " +
                "VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setInt(1, follower.getUserId());
            ps.setInt(2, follower.getFollowerId());

            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();

    }

    public boolean isFollow(int userId, int followerId) {
        String sql = "SELECT COUNT(*) FROM followers WHERE userId = ? AND followerId = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, followerId);
        return count > 0;
    }

    @Override
    public void delete(int id) {

    }

    public void deleteById(int userId, int followerId) {
        String sql = "DELETE FROM followers WHERE userId=? AND followerId=? ";
        jdbcTemplate.update(sql, userId, followerId);
    }

    @Override
    public void update(Object obj) {

    }
}
