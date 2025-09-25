package kr.co.sborad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FindController {


    @GetMapping("/find/changepassword")
    public String changepassword(){
        return "find/changepassword";
    }
    @GetMapping("/find/password")
    public String password(){
        return "find/password";
    }
    @GetMapping("/find/resultuserid")
    public String resultuserid(){
        return "find/resultuserid";
    }
    @GetMapping("/find/userid")
    public String userid(){
        return "find/userid";
    }
}
