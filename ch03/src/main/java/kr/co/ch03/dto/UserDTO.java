package kr.co.ch03.dto;


import lombok.*;
//lombok을 사용하여 다 생성 (기존 jsp에서 gettet , setter , tosring)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO { // Lombok 사용

    private String uid;
    private String name;
    private String birth;
    private int age;


}


