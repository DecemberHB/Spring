package kr.co.ch05.ch05.mapper;

import kr.co.ch05.ch05.dto.User2DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//user2.xml ==
@Mapper // 필수선언
public interface User2Mapper {

    public void insertUser2(User2DTO user2DTO);
    public User2DTO selectUser2(String userid);
    public List<User2DTO> selectAllUser2();
    public void updateUser2(User2DTO user2DTO);
    public void deleteUser2(String userid);

}
