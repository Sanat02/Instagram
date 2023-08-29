package kg.attractor.instagram.dao;

import kg.attractor.instagram.model.Comment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Component
public class CommentDao extends BaseDao {
    CommentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public int save(Object obj) {
        Comment comment = (Comment) obj;
        String sql = "INSERT INTO comments (userId,followerId,imageId,comment,commentDate)  " +
                "VALUES(?,?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setInt(1, comment.getUserId());
            ps.setInt(2, comment.getFollowerId());
            ps.setInt(3, comment.getImageId());
            ps.setString(4, comment.getComment());
            ps.setDate(5, java.sql.Date.valueOf(comment.getCommentDate()));
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();

    }

    public List<Comment> getCommentsByImageId(int imageId) {
        String sql = "SELECT * FROM comments WHERE imageId=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Comment.class),imageId);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Object obj) {

    }
}
