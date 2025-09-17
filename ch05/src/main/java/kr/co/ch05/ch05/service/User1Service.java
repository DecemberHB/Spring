package kr.co.ch05.ch05.service;

import kr.co.ch05.ch05.dto.User1DTO;
import kr.co.ch05.ch05.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class User1Service {

//    @Autowired
//    private User1Mapper mapper; // 필드 주입 권장 XX
//

    private final User1Mapper mapper; //@RequiredArgsConstructor final 속성을 초기화해주는 @


    // 상단 @RequiredArgsConstructor 어노테이션 의존성 주입
    public List<User1DTO> findAll(){
        return mapper.selectAllUser1();
    }
    public User1DTO findByid(String uid){
        return mapper.selectUser1(uid);
    }
    public void register(User1DTO user1DTO){
        mapper.insertUser1(user1DTO);

    }
    public void modify(User1DTO user1DTO){
        mapper.updateUser1(user1DTO);

    }
    public void remove(String uid){
        mapper.deleteUser1(uid);

    }
}
