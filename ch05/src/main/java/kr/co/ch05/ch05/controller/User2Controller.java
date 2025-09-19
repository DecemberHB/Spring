package kr.co.ch05.ch05.controller;


import kr.co.ch05.ch05.dto.User2DTO;
import kr.co.ch05.ch05.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//필수 선언
@Controller
@RequiredArgsConstructor // 서비스 호출에 필요함 모르면? 외워
public class User2Controller {
    private final User2Service user2Service;

    @GetMapping("/user2/register")
    public String register(){
        return "user2/register"; // 사용자가 버튼 클릭 -> 그 화면 보여주는거
    }
    @PostMapping("/user2/register") // 신규 생성 (등록) 페이지에서 넘어온 매개변수 DTO
    public String register(User2DTO user2DTO){
        System.out.println(user2DTO);
        user2Service.register(user2DTO);

        return "redirect:/user2/list"; // 다시 리스트 홈페이지로 빠꾸
    }

    @GetMapping("/user2/list")
    public String list(Model model){ // 맨처음 보여주는 화면
        List<User2DTO> dtoList = user2Service.findAll();
        model.addAttribute("dtoList",dtoList); // html 페이지로 넘겨주기 위해 모델 사용
        return "user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("userid") String userid, Model model){
 // 수정하기위해서 사용자의 usdrid를 파람 값으로 전달 받았음, 사용자에게 그 정보로 조회된 정보를 표출해주기 위해 모델사용
    User2DTO user2DTO = user2Service.findById(userid); //user2DTO 정보에 사용자가 입력한 userid로 조회한 정보 전달 (model로)

        model.addAttribute("user2DTO",user2DTO);
                return "user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        user2Service.modify(user2DTO);
        return "redirect:/user2/list";
    }
    @GetMapping("/user2/delete")
    public String delete(@RequestParam("userid") String userid){
        user2Service.remove(userid);
        return "redirect:/user2/list";

    }
}
