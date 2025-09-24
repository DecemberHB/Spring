package kr.co.ch08.entity;

import jakarta.persistence.*;
import kr.co.ch08.dto.User4DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="TB_USER4")
public class User4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String name;
    private int age;
    private  String address;

    // Entity -> DTO 변환
    public User4DTO toDTO(){
        return User4DTO
                .builder()
                .no(no)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
