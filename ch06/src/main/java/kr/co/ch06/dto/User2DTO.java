package kr.co.ch06.dto;


import kr.co.ch06.Entity.User1;
import kr.co.ch06.Entity.User2;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String userid;
    private String name;
    private String birth;
    private int age;

    // DTO → Entity 변환
    public User2 toEntity() {
        return User2.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}

