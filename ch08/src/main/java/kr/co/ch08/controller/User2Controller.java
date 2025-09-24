package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User2Controller {
    private  final User2Service user2Service;

    //사용자 전체 리스트 출력 GET
    @GetMapping("/user2")
    public ResponseEntity<List<User2DTO>> listAll(){
        List<User2DTO> dtoList = user2Service.getUserAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    //사용자 조회( ID로 ) - GET
    @GetMapping("/user2/{userid}")
    public ResponseEntity<User2DTO> getUserById(@PathVariable("userid") String userid){
        log.info("user2 userid={}", userid);

        User2DTO user2DTO = user2Service.getUser(userid);

        return ResponseEntity.status(HttpStatus.OK).body(user2DTO);
    }

    // 사용자 등록(데이터 추가)
    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO user2DTO){
        log.info("user2 userid={}", user2DTO.getUserid());

        User2DTO saveUser2= user2Service.save(user2DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saveUser2);
    }

    //사용자 수정
    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO user2DTO){
        log.info("user2 userid={}", user2DTO.getUserid());
        User2DTO savedUser2= user2Service.modify(user2DTO);

        return ResponseEntity.status(HttpStatus.OK).body(savedUser2);
    }

    // 사용자 삭제(데이터 삭제)

    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid){
        log.info("user2 userid={}", userid);
        boolean isSuccess = user2Service.delete(userid);

        return ResponseEntity.status(HttpStatus.OK).body(isSuccess);

    }
}
