package kg.attractor.instagram.dao;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class BaseDao {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    KeyHolder keyHolder;

     BaseDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.keyHolder = new GeneratedKeyHolder();
    }

    public abstract int save(Object obj);

    public abstract void delete(int id);

    public abstract void update(Object obj);
}
