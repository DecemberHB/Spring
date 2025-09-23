package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User2DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TB_User2")
public class User2 {

    @Id
    private String userid;

    @Column(name="name")
    private String name;
    private String birth;
    private int age;

    // DTO 변환 메서드 정의

    public User2DTO toDTO(){
        return User2DTO.builder()
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }



    }
