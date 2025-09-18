package kr.co.ch04.mapper;

import kr.co.ch04.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1MapperTest {

    @Autowired
    private User1Mapper user1Mapper;

    private String userid = "a879";
    @Test
    void insert() {

        // Given - 테스트를 실행하기 위한 준비 단계

        User1DTO user1DTO = User1DTO.builder()
                                    .uid("a879")
                                    .name("삼색고양이")
                                    .birth("2021-09-21")
                                    .age(4)
                                    .build();
        // When - 테스트 수행
        user1Mapper.insert(user1DTO);

        // Then
        User1DTO saveUser = user1Mapper.select(user1DTO.getUid());
        assertNotEquals(user1DTO.getUid(), saveUser.getUid());
    }


    @Test
    void selectAll() {



        //When
        List<User1DTO> dtoList = user1Mapper.selectAll();
        //Then
        System.out.println(dtoList);
        //assertTrue(dtoList.isEmpty()); //테스트 실패로 출력
        assertFalse( dtoList.isEmpty() ); // 테스트 성공으로 출력
    }

    @Test
    void select() {

    }

    @Test
    void update() {

        //Given
        User1DTO user1DTO = User1DTO.builder()
                .uid("o021")
                .name("삼색고양이")
                .birth("2008-11-11")
                .age(14)
                .build();
        //When
        user1Mapper.update(user1DTO);
        //Then
        User1DTO modifiedUser = user1Mapper.select(user1DTO.getUid());
        assertEquals(user1DTO,modifiedUser); // 객체 비교 DTO에 @Data 어노테이션 선언
    }

    @Test
    void delete() {

        //Given
        String uid = "o021";
        //When
        user1Mapper.delete(uid);
        //Then
        User1DTO deletedUser = user1Mapper.select(uid);
        assertNull( deletedUser);
    }
}