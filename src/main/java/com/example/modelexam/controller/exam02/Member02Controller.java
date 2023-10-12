package com.example.modelexam.controller.exam02;


import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam01.MemberService;
import com.example.modelexam.service.exam02.Member02Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam01
 * fileName : MemberController
 * author : GGG
 * date : 2023-10-10
 * description : 멤버 컨트롤러 - 화면 & 업무로직 중간 역할 (리모콘 역할)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
@Controller
@Slf4j
@RequestMapping("/exam02")
public class Member02Controller {
    @Autowired
    Member02Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model){
        List<Member> list  = memberService.findAll();
        model.addAttribute("list",list);

//      TODO : 로깅
        log.debug(list.toString());
        return "exam02/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable long eno,
                              Model model){
        Member member = memberService.findById(eno);
        model.addAttribute("member",member);
        return "exam02/member/member_id.jsp";
    }
}
