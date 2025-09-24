package kr.co.ch08.service;

import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository user2Repository;

    // 사용자 등록
    public User2DTO save(User2DTO user2DTO){
        User2 savedUser2 = user2Repository.save(user2DTO.toEntity());
        return savedUser2.toDTO();
    }

    //사용자 조회 ( ID로 )
    public User2DTO getUser(String userid){ // id로 조회해서 사용자 존재 여부 및 데이터 조회
        Optional<User2> optUser2 = user2Repository.findById(userid);

        if(optUser2.isPresent()){
            User2 user2 = optUser2.get();
            return user2.toDTO();
        }
        return null;
    }

    // 사용자 전체 조회
    public List<User2DTO> getUserAll(){
        List<User2> list = user2Repository.findAll();
        return list.stream()
                .map(entity->entity.toDTO())
                .toList();
    }

    // 사용자 수정
    public User2DTO modify(User2DTO user2DTO){
        if(user2Repository.existsById(user2DTO.getUserid())){ // id로 조회해서 사용자가 있는지만 조회
            User2 modifyedUser2 = user2Repository.save(user2DTO.toEntity());
            return modifyedUser2.toDTO();
        }
        return null;
    }

    // 사용자 삭제
    public boolean delete(String userid){
        if(user2Repository.existsById(userid)){
            user2Repository.deleteById(userid);
            return true;
        }
        return false;
    }

}
