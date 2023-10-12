package com.example.modelexam.controller.exam03;


import com.example.modelexam.model.Member;

import com.example.modelexam.service.exam03.Member03Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/exam03")
public class Member03Controller {
    @Autowired
    Member03Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model){
        List<Member> list  = memberService.findAll();
        model.addAttribute("list",list);

//      TODO : 로깅
        log.debug(list.toString());
        return "exam03/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable long eno,
                              Model model){
        Member member = memberService.findById(eno);
        model.addAttribute("member",member);
        return "exam03/member/member_id.jsp";
    }

//   TODO : @ResponseBody : 함수의 리턴값을 json 데이터로 변경하는 어노테이션
    @PostMapping("/member")
    @ResponseBody
    public List<Member> createMember(@RequestBody Member member){
//      TODO : 서비스 저장함수 호출
        List<Member> list = memberService.save(member);

     return list;
    }

}
