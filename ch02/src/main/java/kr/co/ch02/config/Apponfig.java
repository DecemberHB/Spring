package kr.co.ch02.config;

import kr.co.ch02.sub1.Hello;
import kr.co.ch02.sub1.Welcome;

import java.beans.BeanProperty;

@Configuration
@Componet
public class Apponfig {


    //스프링 컨테이너 빈(객체)등록

    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean(name="wc")
    public Welcome welcome(){
        return new Welcome();
    }
}
