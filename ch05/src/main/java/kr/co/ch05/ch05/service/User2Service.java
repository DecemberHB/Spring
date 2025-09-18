package kr.co.ch05.ch05.service;

import kr.co.ch05.ch05.dto.User2DTO;
import kr.co.ch05.ch05.mapper.User2Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Mapper user2Mapper;


    public void register(User2DTO user2DTO){
        user2Mapper.insertUser2(user2DTO);
    }
    public User2DTO findById(String userid){
        return user2Mapper.selectUser2(userid);
    }
    public List<User2DTO> findAll(){
        return user2Mapper.selectAllUser2();
    }
    public void modify(User2DTO user2DTO){
        user2Mapper.updateUser2(user2DTO);
    }
    public void remove(String userid){
        user2Mapper.deleteUser2(userid);
    }
}
