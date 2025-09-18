package kr.co.ch04.service;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User1Service {


    private final User1Mapper mapper; // Bean 주입?

    // 2번쨰 방법
//    @Autowired
//    public User1Service(User1Mapper mapper) {
//        this.mapper = mapper;
//    }

    public List<User1DTO> findAll(){
        return mapper.selectAll();
    }
    public User1DTO findById(String uid){
        return mapper.select(uid);
    }
    public void register(User1DTO user1DTO){
        mapper.insert(user1DTO);
    }
    public void modify(User1DTO user1DTO){
        mapper.update(user1DTO);
    }
    public void remove(String uid){
        mapper.delete(uid);
    }



}
