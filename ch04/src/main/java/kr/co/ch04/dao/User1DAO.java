package kr.co.ch04.dao;


import kr.co.ch04.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

// 어노테이션 추가
//@RequestParam // 얘도 되고
@RequiredArgsConstructor
@Component // 이고도 되고
public class User1DAO {

    private final JdbcTemplate jdbcTemplate; // JSP와 다른점 -> 쿼리를 실행시켜주는 스프링 JDBC 객체

    public void insert(User1DTO user1DTO) {

        //쿼리 작성
        String sql = "INSERT INTO USER1 (uid, name, birth, age) VALUES (?,?,?,?)";
        Object[] params = {
            user1DTO.getUid(),
            user1DTO.getName(),
            user1DTO.getBirth(),
            user1DTO.getAge()
        }; //오브젝트 배열객체로 만들어줘야함
        jdbcTemplate.update(sql, params); //executeUpdate() 실행
    }

    public List<User1DTO> selectAll() {
        String sql = "SELECT * FROM USER1";
        return jdbcTemplate.query(sql, new User1RowMapper());
    }
    public User1DTO select(String uid) {
        String sql = "SELECT * FROM USER1 WHERE uid = ?";
        return jdbcTemplate.queryForObject(sql,new User1RowMapper(),uid);

    }
    public void update(User1DTO user1DTO) {
        String sql = "UPDATE USER1 SET name = ?,birth =?, age = ? WHERE uid = ?";
        Object[] params = {
                user1DTO.getName(),
                user1DTO.getBirth(),
                user1DTO.getAge(),
                user1DTO.getUid()
        }; //오브젝트 배열객체로 만들어줘야함
        jdbcTemplate.update(sql, params); //executeUpdate() 싱행
    }
    public void delete(String uid) {
        String sql = "DELETE FROM USER1 WHERE uid = ?";
        jdbcTemplate.update(sql, uid);
    }
}

