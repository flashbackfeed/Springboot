package com.example.modelexam.service.exam03;


import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Dept;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : MemberService
 * author : GGG
 * date : 2023-10-10
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
@Service
public class Member03Service {
    @Autowired
    MemberDao memberDao;
    public List<Member> findAll(){
//      TODO : memberDao.selectAll() : db 조회 함수 호출
        List<Member> list = memberDao.selectAll();
        return list;
    }
//   todo: 연습 2)
//    Member02Service 클래스를 만들고 findById() 함수를 정의한다.
//    Member02Controller 클래스를 만들어서 getMemberId() 함수를 정의하고,
//    샘플데이터 뷰로(jsp : member_id.jsp) 전송해 보세요.
//    url : /member/{eno}
//    jsp : exam02/member/member_id.jsp

    public Member findById(long eno){
//      TODO : 상세조회(1건조회)
        Member member = memberDao.selectById(eno);

        return member;
    }

//  TODO : 회원 저장 함수
    public List<Member> save(Member member){
        List<Member> list = memberDao.insert(member);
        return list;
    }
}
