package kr.co.ch06.repository;

import kr.co.ch06.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> {

    // 필드명과 메서드 이름을 맞춤 (userid 필드 기준)
    public User1 findUser1ByUserid(String userid);
    public List<User1> findUser1ByName(String name);
    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUseridAndName(String userid, String name);
    public List<User1> findUser1ByUseridOrName(String userid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByUserid(String userid);
    public int countUser1ByName(String name);

    // JPQL 실습
    @Query("SELECT u1 FROM User1 u1 WHERE u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 u1 WHERE u1.name = ?1")
    public List<User1> selectUser1WhereName(String name);

    @Query("SELECT u1 FROM User1 u1 WHERE u1.birth = :birth")
    public List<User1> selectUser1WhereBirth(@Param("birth") String birth);

    // 컬럼 일부 선택 시 List<Object[]> 사용
    @Query("SELECT u1.userid, u1.name, u1.age FROM User1 u1 WHERE u1.userid = :userid")
    public List<Object[]> selectUser1WhereId(@Param("userid") String userid);

    // JOIN 예제
    @Query("SELECT p, c FROM Parent p JOIN Child c ON p.pid = c.pid WHERE p.pid = :pid")
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);
}
