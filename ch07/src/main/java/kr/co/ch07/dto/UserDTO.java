package kr.co.ch07.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @Id
    private String usid;
    private String pass;
    private String name;
    private int age;
    private String role;
    private String regDate;

    // 변환메서드
    public User toEntity(){
        return User.builder()
                .usid(usid)
                .pass(pass)
                .name(name)
                .age(age)
                .role(role)
                .build();
    }
}
