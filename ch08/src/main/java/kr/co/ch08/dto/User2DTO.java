package kr.co.ch08.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.entity.User2;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {


        private String userid;
        private String name;
        private int age;
        private  String address;

        // DTO -> Entity 변환

        public User2 toEntity() {
            return User2.builder()
                    .userid(userid)
                    .name(name)
                    .age(age)
                    .address(address)
                    .build();

        }



}
