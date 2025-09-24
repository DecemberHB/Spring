package kr.co.ch08.controller;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.repository.User3Repository;
import kr.co.ch08.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service user3Service;
    // 사용자 전체 조회 ( 리스트 ) GET !

    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list() {
        List<User3DTO> dtoList = user3Service.getUserAll();
        return ResponseEntity.ok().body(dtoList);
    }

    // 사용자 검색 ( 조회)
    public ResponseEntity<User3DTO> user3(@PathVariable String userid) {
        log.info("user3 id: {}", userid);

        User3DTO user3DTO = user3Service.getUser(userid);

        return ResponseEntity.status(HttpStatus.FOUND).body(user3DTO);
    }

    //사용자 등

}

