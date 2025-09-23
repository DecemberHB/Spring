package kr.co.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.UserDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="TB_SC_USER")
public class User {

    @Id
    private String usid;
    private String pass;
    private String name;
    private int age;
    private String role;

    @CreationTimestamp
    private LocalDateTime regDate;

    // 변환메서드
    public UserDTO toDTO(){
        return UserDTO.builder()
                .usid(usid)
                .pass(pass)
                .name(name)
                .age(age)
                .role(role)
                .regDate(regDate.toString())
                .build();
    }
}
