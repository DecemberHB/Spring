package kr.co.ch06.dto;


import kr.co.ch06.Entity.User1;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {

    private String userid;
    private String name;
    private String birth;
    private int age;

    // DTO → Entity 변환
    public User1 toEntity() {
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}

