package kr.co.ch06.service;

import kr.co.ch06.entity.User2;
import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class User2Service {
    private final User2Repository user2Repository;

    public void save(User2DTO user2DTO){
        // save() : JPA의 기본 Insert 메서드
        User2 user2 = user2DTO.toEntity();
        user2Repository.save(user2);
    }
    public List<User2DTO> getUsers() {

        //findAll : JPA 전체 조회리스트
        List<User2> list  = user2Repository.findAll();

        // Entity 리스트를 가져온 뒤에 DTO로 반환

        List<User2DTO> dtoList = list.stream()
                .map(entity->entity.toDTO())
                .collect(Collectors.toList());

        return dtoList;

    }
    public User2DTO getUser(String userid){
        /*
        *   findById() : JPA 기본 select 메서드, 반환값은 Option 타입
        *   Optional<엔티티> 타입은 null 체크 검정을 안전하게 처리하기 위한 jPA 반환 타입임
        *
        *
        * */

        Optional<User2> optuser2 = user2Repository.findById(userid);

        // if 문을 통해 검증 Entity 가 존재한다면 ~
        if(optuser2.isPresent()){
            User2 user2 = optuser2.get();

            // 이제 받은 Entity를 DTO로 변환해서 반환
            return user2.toDTO();
        }
        return null;
    }

    public void modify(User2DTO user2DTO){
        User2 user2 = user2DTO.toEntity();

        // Entity수정
        user2Repository.save(user2);


    }

    public void delete(String userid){
        user2Repository.deleteById(userid);

    }
}
