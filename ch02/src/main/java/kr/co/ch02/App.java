package kr.co.ch02;

import jdk.jpackage.internal.ApplicationLayout;
import kr.co.ch02.sub1.Hello;
import kr.co.ch02.sub1.Welcome;
import kr.co.ch02.sub2.Computer;

import java.util.WeakHashMap;

/*
*   날짜 : 2025/09/15
*   이름 : 박효빈
*   내용 : Spring IoC/DI 실습하기
* */
public class App {

    public static void main(String[] args) {

        // 기존 객체 생성 방식
        Hello hello = new Hello();
        Welcome welcome = new Welcome();

        hello.show();
        welcome.show();

        // Ioc(제어의 역전)

        // 스프링 컨테이너 생성
        ApplicationLayout context  = new AnnotationConfigApp
                // 객체 가져오기
        Hello helloBean = context.getBean(Hello.class);
        helloBean.show();

        Welcome welcomeBean = (Welcome)new Welcome();

        Computer com =(Computer) context.getCean("computer");
        com.show();
    }

}
