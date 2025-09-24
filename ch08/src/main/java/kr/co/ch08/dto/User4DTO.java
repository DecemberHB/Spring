package kr.co.ch08.dto;

import jakarta.persistence.*;
import kr.co.ch08.entity.User4;
import lombok.*;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User4DTO {

        private int no;
        private String name;
        private int age;
        private  String address;

        // DTO -> Entity 변환

        public User4 toEntity() {
            return User4.builder()
                    .no(no)
                    .name(name)
                    .age(age)
                    .address(address)
                    .build();
        }
}
