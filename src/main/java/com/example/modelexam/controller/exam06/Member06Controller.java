package com.example.modelexam.controller.exam06;



import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam06.Member06Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
@RequestMapping("/exam06")
public class Member06Controller {
    @Autowired
    Member06Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model){
        List<Member> list  = memberService.findAll();
        model.addAttribute("list",list);

//      TODO : 로깅
        log.debug(list.toString());
        return "exam06/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable long eno,
                              Model model){
        Member member = memberService.findById(eno);
        model.addAttribute("member",member);
        return "exam06/member/member_id.jsp";
    }

////   TODO : @ResponseBody : 함수의 리턴값을 json 데이터로 변경하는 어노테이션
//    @PostMapping("/member")
//    @ResponseBody
//    public List<Member> createMember(@RequestBody Member member){
////      TODO : 서비스 저장함수 호출
//        List<Member> list = memberService.save(member);
//
//     return list;
//    }

    //  TODO : 새로운 회원 추가 페이지 열기 함수
    @GetMapping("/member/addition")
    public String addMember(){
        return "exam06/member/add_member.jsp";
    }
    //  TODO : DB 저장하기 함수
    @PostMapping("/member/add")
    public RedirectView createMember(@ModelAttribute Member member){
        memberService.save(member);
//      TODO : 전체 조회 페이지
        return new RedirectView("/exam06/member");
}

//  TODO : 회원 수정 페이지 열기 함수 : 상세조회 필요
    @GetMapping("/member/edition/{eno}")
    public String editMember(@PathVariable long eno, Model model){
        Member member = memberService.findById(eno);
        model.addAttribute("member",member);
        return "exam06/member/update_member.jsp";
    }
//  TODO : DB 수정 저장 함수 : 수정 후 전체 조회페이지로 강제 이동(리다이렉트)
    @PutMapping("/member/edit/{eno}")
    public RedirectView updateMember(@PathVariable long eno,
                                     @ModelAttribute Member member){
            memberService.save(member);

        return new RedirectView("/exam06/member");
    }

    @DeleteMapping("member/delete/{eno}")
    public RedirectView deleteMember(@PathVariable int eno){
        memberService.removeById(eno); // db 삭제 함수 호출

      return new RedirectView("/exam06/member"); // 전체 조회 사이트
    }

}
