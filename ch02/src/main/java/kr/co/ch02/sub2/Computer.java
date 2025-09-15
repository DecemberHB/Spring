package kr.co.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

    //필드주입
    @Autowired
    private  CPU cpu;

    private RAM ram;


    // 생성자 주입 (final 속성) -- 많이쓰임
    @Autowired
    public Computer(RAM ram){
        this.ram = ram;
    }

    //새터 주입
}
