package kr.co.ch08.controller;


import kr.co.ch08.dto.User4DTO;
import kr.co.ch08.service.User4Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class User4Controller {
    private final User4Service user4Service;

    // 사용자 전체 조회 (GET /user4)
    @GetMapping("/user4")
    public ResponseEntity<List<User4DTO>> list(){
        List<User4DTO> dtoList = user4Service.getUserAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    //사용자 검색(GET /user4/{no})
    @GetMapping("/user4/{no}")
    public ResponseEntity<User4DTO> user4(@PathVariable int no){
        log.info("user4 no : {}", no);
        User4DTO user4DTO = user4Service.getUser(no);
        return ResponseEntity.status(HttpStatus.FOUND).body(user4DTO);

    }

    // 사용자 등록( POSE /user4)

    @PostMapping("/user4")
    public ResponseEntity<User4DTO> register(User4DTO user4DTO)
    {
        log.info("user4DTO : {}", user4DTO);
        User4DTO savedUser4 = user4Service.save(user4DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser4);
    }

    // 사용자 수정 modifyde *POST /user4/{no}
    public ResponseEntity<User4DTO> modify(@RequestBody User4DTO user4DTO)
    {
        log.info("user4DTO : {}", user4DTO);
        User4DTO modifydeUser4 = user4Service.modify(user4DTO);

        return ResponseEntity.status(HttpStatus.OK).body(modifydeUser4);
    }

    //사용자 삭제 GET DELETE /user4/{no}
    public ResponseEntity<Boolean> delete(@PathVariable int no){
        log.info("user4 no : {}", no);
        Boolean isSuccess = user4Service.delete(no);
        return  ResponseEntity.status(HttpStatus.OK).body(isSuccess);
    }

}
