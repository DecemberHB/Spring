package kr.co.ch07.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    // 인자값 http 설정 해야함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 로그인 설정
        http.formLogin(form -> form
                        .loginPage("/user/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/user/login?error=true")
                        .usernameParameter("usid")
                        .passwordParameter("pass")
        );
        // 로그아웃 설정
      http.logout(logout -> logout
              .logoutUrl("/logout")
              .invalidateHttpSession(true)
              .logoutSuccessUrl("/user/login?logout=true"));

        // 인가 설정
        http.authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll()
        );

        // 기타 설정
        http.csrf(CsrfConfigurer::disable); // 람다식


        return http.build();
    }

    @Bean // 암호화 객체
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
