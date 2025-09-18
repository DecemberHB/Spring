package kr.co.ch04.controller;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j // jsp에서 쓰던 로그 의존성 주입
@Controller
public class User1Controller {

    private final User1Service service;
    @GetMapping("/user1/register")
    public String register(){

        return "/user1/register";
    }
    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){

        log.debug(user1DTO.toString()); // 제대로 전송되어 들어오는지 확인
        log.info("log info...");
        log.warn("log warn...");
        service.register(user1DTO);
        return "redirect:/user1/list";

    }
    @GetMapping("/user1/list")
    public String list(Model model){
        List<User1DTO> dtoList = service.findAll();

        model.addAttribute("dtoList",dtoList);
        return "/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(Model model, @RequestParam("uid") String uid){
        User1DTO user1DTO = service.findById(uid);
        model.addAttribute("dto",user1DTO);
        return "/user1/modify";
    }
    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping
    public String remove(@RequestParam("uid") String uid){
        service.remove(uid);
        return "redirect:/user1/list";
    }

}
