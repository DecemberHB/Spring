package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User1DTO;
import lombok.*;

@Getter
//@Setter Entity 에서는 Setter 불변성을 위해 금지
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // 기본키를 필수로 줘야함 @Id <<< 얘임
@Table(name="TB_User1") // 생성되는 테이블 명 왠만하면 TB_ << 붙혀야함 오라클은 예약어가 많아서 좀 그럼
public class User1 {

    @Id // PK 컬럼 선언
    private String userid;

    @Column(name = "name") // 매핑컬럼 , 일반적으로 생략
    private String name;

    private String birth;

    private int age;

    // DTO 변환 메서드 정의

    public User1DTO toDTO(){
       return User1DTO
               .builder()
               .userid(userid)
               .name(name)
               .birth(birth)
               .age(age)
               .build();


    }
}
