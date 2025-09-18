package kr.co.ch05.ch05.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String userid;
    private String name;
    private String birth;
    private int age;
}
