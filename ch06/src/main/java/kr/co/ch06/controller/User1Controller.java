package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service service;

    // 전체 리스트 조회
    @GetMapping("/user1/list")
    public String list(Model model){
        List<User1DTO> dtoList = service.getUsers();
        model.addAttribute("dtoList", dtoList);
        return "user1/list"; // list/html 보여주기
    }

    // 회원 등록 페이지(GET)
    @GetMapping("/user1/register")
    public String registerForm(Model model){
        model.addAttribute("user1DTO", new User1DTO()); // 빈 DTO 전달
        return "user1/register"; // register/html 보여주기
    }

    // 회원 등록 처리(POST)
    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        service.save(user1DTO);
        return "redirect:/user1/list"; // 저장 후 리스트로 이동
    }

    // 회원 수정 페이지(GET)
    @GetMapping("/user1/modify")
    public String modifyForm(@RequestParam String userid, Model model){
        User1DTO user1DTO = service.getUser(userid);
        model.addAttribute("user1DTO", user1DTO);
        return "user1/modify"; // modify/html 보여주기
    }

    // 회원 수정 처리(POST)
    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    // 회원 삭제 처리(GET)
    @GetMapping("/user1/delete")
    public String delete(@RequestParam String userid){
        service.delete(userid);
        return "redirect:/user1/list"; // 삭제 후 리스트로
    }
}
