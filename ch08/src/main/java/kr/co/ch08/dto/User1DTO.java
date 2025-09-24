package kr.co.ch08.dto;

import jakarta.validation.constraints.*;
import kr.co.ch08.entity.User1;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {


    @NotBlank // null, **. " " 모두 허용 안함 널, 빈문자 공백 <<
    @Pattern(regexp = "^[a-z0-9]{4,10}$",message = "영어 소문자, 숫자 조합 최소 4~10자리 입력")
    private String userid;

    @NotEmpty // null, "" : null, 공백 허용 X
    @Pattern(regexp = "^[가-힣]{2,10}$",message = "이름은 한글로 2~10자 입력")
    private String name;

    @NotNull // Null 허용 X
    private String birth;

    @Min(1)
    @Max(100)
    private int age;

    @Email // 이메일형식
    private String email;

    // DTO -> Entity 변환
    public User1 toEntity() {
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}
