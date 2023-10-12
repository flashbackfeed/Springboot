package com.example.modelexam.service.exam05;


import com.example.modelexam.dao.MemberDao;
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
public class Member05Service {
    @Autowired
    MemberDao memberDao;
    public List<Member> findAll(){
//      TODO : memberDao.selectAll() : db 조회 함수 호출
        List<Member> list = memberDao.selectAll();
        return list;
    }
    public Member findById(long eno){
//      TODO : 상세조회(1건조회)
        Member member = memberDao.selectById(eno);

        return member;
    }

////  TODO : 회원 저장 함수
//    public List<Member> save(Member member){
//        List<Member> list = memberDao.insert(member);
//        return list;
//    }
    public List<Member> save(Member member){

        List<Member> list = null;
//        TODO : ui(frontend) -> insert (사원번호가 없으면)
        if(member.getEno() == null){
//        TODO: 새로운 사원번호 생성
            int count = memberDao.selectAll().size();
            int newEno = (count + 8000);
            member.setEno(newEno); // 새로운 사원번호 저장
            list = memberDao.insert(member);
        }else{
            list = memberDao.update(member);
        }
        return list;
    }

//  todo: 연습 5)
//    Member05Service 클래스를 만들고 save() 함수를 정의한다.
//    Member05Controller 클래스를 만들어서 editMember(), updateMember() 함수를 정의
//    editMember()
//    - url : /member/edition/{eno}
//    - jsp : exam05/member/update_member.jsp
//    updateMember()
//    - url : /member/edit/{eno}
//    - redirect url : /exam05/member
}
