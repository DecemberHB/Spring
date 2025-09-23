package kr.co.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_user")
public class User {

    @Id
    private String userid;
    private String name;
    private int age;

}