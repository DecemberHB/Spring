package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.repository.User3Repository;
import kr.co.ch08.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service user3Service; // 서비스 객체 주입

    // 사용자 전체 조회 (GET /user3)
    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list() {
        List<User3DTO> dtoList = user3Service.getUserAll(); // 서비스에서 전체 사용자 리스트 가져오기
        return ResponseEntity.ok().body(dtoList); // HTTP 200 + 리스트 반환
    }

    // 사용자 검색 (GET /user3/{userid})
    @GetMapping("/user3/{userid}")
    public ResponseEntity<User3DTO> user3(@PathVariable String userid) {
        log.info("user3 id: {}", userid); // 조회할 사용자 id 로깅
        User3DTO user3DTO = user3Service.getUser(userid); // 서비스에서 특정 사용자 조회
        return ResponseEntity.status(HttpStatus.FOUND).body(user3DTO); // HTTP 302 + DTO 반환
    }

    // 사용자 등록 (POST /user3)
    @PostMapping("/user3")
    public ResponseEntity<User3DTO> register(@Valid @RequestBody User3DTO user3DTO){
        log.info("user3 DTO: {}", user3DTO); // 등록할 사용자 DTO 로깅
        User3DTO savedUser3 = user3Service.save(user3DTO); // 서비스에서 DTO 저장 (insert)
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 생성 성공
                .body(savedUser3); // 저장된 DTO 반환
    }

    // 사용자 수정 (POST /user3/{userid}) → REST 원칙상 PUT 권장
    @PostMapping("/user3/{userid}")
    public ResponseEntity<User3DTO> modify(@RequestBody User3DTO user3DTO){
        log.info("user3 DTO: {}", user3DTO); // 수정할 사용자 DTO 로깅
        User3DTO savedUser3 = user3Service.modify(user3DTO); // 서비스에서 DTO 수정 (update)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedUser3); // HTTP 202 + 수정된 DTO 반환
    }

    // 사용자 삭제 (DELETE /user3/{userid})
    @DeleteMapping("/user3/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable String userid) {
        log.info("user3 id: {}", userid); // 삭제할 사용자 id 로깅
        Boolean isSuccess = user3Service.delete(userid); // 서비스에서 삭제
        return ResponseEntity.status(HttpStatus.OK).body(isSuccess); // HTTP 200 + 삭제 성공 여부 반환
    }
}
