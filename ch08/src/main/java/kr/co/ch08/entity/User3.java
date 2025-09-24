package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User3DTO;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="TB_USER3")
public class User3 {

    @Id
    private String userid;
    private String name;
    private String role;
    private LocalDateTime regDate;

    // Entity -> DTO 변환

    public User3DTO toDTO(){

        return User3DTO.builder()
                .userid(userid)
                .name(name)
                .role(role)
                .regDate(regDate)
                .build();

    }



}
