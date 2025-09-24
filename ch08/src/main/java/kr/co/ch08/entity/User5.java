package kr.co.ch08.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="TB_USER5")
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String name;
    private int age;
    private  String gender; // M , F
    private LocalDate address;
}
