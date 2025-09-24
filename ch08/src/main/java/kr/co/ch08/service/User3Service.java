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

    private final User3Repository user3Repository; // User3 엔티티 DB 처리용 Repository 주입

    // 사용자 등록: DTO → Entity 변환 후 저장, 저장된 Entity → DTO 반환
    public User3DTO save(User3DTO user3DTO) {
        User3 savedUser3 = user3Repository.save(user3DTO.toEntity()); // 저장 핵심: JPA save()가 Insert 처리
        return savedUser3.toDTO(); // 컨트롤러로 보낼 DTO 반환
    }

    // ID로 단일 사용자 조회: Optional로 존재 확인 후 DTO 반환
    public User3DTO getUser(String userid){
        Optional<User3> optUser3 = user3Repository.findById(userid); // DB에서 조회, Optional로 Null 방지
        if(optUser3.isPresent()){ // 존재 여부 체크
            User3 user3 = optUser3.get(); // 실제 Entity 추출
            return user3.toDTO(); // DTO로 변환하여 반환
        }
        return null; // 존재하지 않으면 null 반환
    }

    // 전체 사용자 조회: findAll()로 리스트 가져와서 DTO 변환
    public List<User3DTO> getUserAll() {
        List<User3> list = user3Repository.findAll(); // DB 전체 조회
        return list.stream()
                .map(entity->entity.toDTO()) // Entity → DTO 변환 람다
                .toList(); // 변환된 DTO 리스트 반환
    }

    // 사용자 수정: 존재 여부 확인 후 save()로 업데이트
    public User3DTO modify(User3DTO user3DTO) {
        if(user3Repository.existsById(user3DTO.getUserid())){ // ID 존재 여부만 체크
            User3 modifiedUser3 = user3Repository.save(user3DTO.toEntity()); // 존재하는 ID가 있으면 JPA가 Update 처리, 없으면 Insert
            return modifiedUser3.toDTO(); // 수정된 Entity → DTO 반환
        }
        return null; // 존재하지 않으면 null
    }

    // 사용자 삭제: 존재 여부 확인 후 deleteById() 호출
    public boolean delete(String userid) {
        if(user3Repository.existsById(userid)){ // ID 존재 여부 체크
            user3Repository.deleteById(userid); // 삭제
            return true; // 삭제 성공
        }
        return false; // 존재하지 않으면 false 반환
    }
}