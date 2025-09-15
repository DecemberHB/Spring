package kr.co.ch02.sub3;


import org.springframework.stereotype.Component;

@Component
public class Service {

    // 포인트컷이 위빙? 된다함 insert , select
    public void findById() {
        System.out.println("핵심 기능 - findById 실행...");
    }

    public void register() {
        System.out.println("핵심 기능 - register 실행...");

    }

    public void modify() {
        System.out.println("핵심 기능 - modify 실행...");

    }

    public void remove() {
        System.out.println("핵심 기능 - remove 실행...");

    }
}
