package kr.co.ch08.service;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.entity.User3;
import kr.co.ch08.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User3Service {

    private final User3Repository user3Repository;

    // 사용자 등록

    public User3DTO save(User3DTO user3DTO) {
        User3 savedUser3 = user3Repository.save(user3DTO.toEntity());
        return savedUser3.toDTO();
    }

    // userid로 사용자 조회
    public User3DTO getUser(String userid){
        Optional<User3> optUser3 = user3Repository.findById(userid);

        if(optUser3.isPresent()){
            User3 user3 = optUser3.get();
            return user3.toDTO();
        }
        return null;
    }

    // 사용자 전체 조회
    public List<User3DTO> getUserAll() {
        List<User3> list = user3Repository.findAll();
        return list.stream()
                .map(entity->entity.toDTO())
                .toList();
    }
    // 사용자수정
    public User3DTO modify(User3DTO user3DTO) {
        if(user3Repository.existsById(user3DTO.getUserid())){
            User3 modifiedUser3 = user3Repository.save(user3DTO.toEntity());
            return modifiedUser3.toDTO();
        }
        return null;
    }

    // 사용자 삭제
    public boolean delete(String userid) {
        if(user3Repository.existsById(userid)){
            user3Repository.deleteById(userid);
            return true;
        }
        return false;
    }
}
