package kg.attractor.instagram.dao;

import kg.attractor.instagram.model.User;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component

public class UserDao extends BaseDao {


    UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT id, account_name as accountName, full_name as fullName, email, role_id as roleId, " +
                "password FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }


    public User getUserByName(String accountName) {
        String sql = "SELECT id, account_name as accountName,  full_name as fullName, email, role_id as roleId, " +
                "password FROM users WHERE account_name = ?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), accountName);
        return user;

    }


    public Optional<User> getUserByEmail(String email) {
        String sql = "SELECT id, account_name as accountName,  full_name as fullName, email, role_id as roleId, " +
                "password FROM users WHERE email = ?";

        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)));

    }


    public boolean isExists(String email) {
        String sql = "SELECT CASE WHEN EXISTS(SELECT * FROM users WHERE email = ?) THEN TRUE ELSE FALSE END";
        return jdbcTemplate.queryForObject(sql, Boolean.class, email);
    }


    @SneakyThrows
    public Optional<User> getUserById(int id) {
        String sql = "SELECT id, account_name as accountName,  full_name as fullName, email, role_id as roleId, " +
                "password FROM users WHERE id = ?";

        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), id)
        ));

    }


    public void updateAccountName(int userId, String newAccountName) {
        String sql = "UPDATE users SET account_name = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, newAccountName, userId);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update account name for user with ID: " + userId, e);
        }
    }


    @Override
    public int save(Object obj) {
        User user = (User) obj;
        String sql = "INSERT INTO users (account_name,full_name, email, role_id, password, enabled) " +
                "VALUES (?, ?, ?, ?, ?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getAccountName());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getRoleId());
            ps.setString(5, user.getPassword());
            ps.setBoolean(6, user.isEnabled());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected != 1) {
            throw new RuntimeException("Failed to delete resume with ID: " + id);
        }
    }

    @Override
    public void update(Object obj) {
//        User user = (User) obj;
//        String sql = "UPDATE users SET account_name = ? , email = ?, " +
//                " account_type = ?, password = ? , phone_number = ? WHERE id = ?";
//
//        jdbcTemplate.update(sql, user.getAccountName(), user.getEmail(), String.valueOf(AccountType.EMPLOYER),
//                user.getPassword(), user.getPhoneNumber(), user.getId());
    }
}
