package com.example.modelexam.service.exam01;

import com.example.modelexam.dao.DeptDao;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : DeptService
 * author : GGG
 * date : 2023-10-06
 * description : 부서 업무 서비스 클래스, @Service, @Autowired,
 *              findAll()
 * 요약 : 
 *         @Service : 업무 로직 담당 클래스 위에 붙이는 어노테이션
 *          => 스프링 서버 가동 될 때 그 클래스를 생성해둠(싱글톤)
 *          => 객체를 만들어서 함수를 쓸 때 : new 생성자함수() 하는데
 *          => 스프링에서는 하지 않고 미리 만들어 둔 객체를 받아서 사용함
 *          ((참고) : IOC : 제어의 역전 )
 *          기타 : @Repository, @Component 등
 *          @Autowired : 스프링에서 미리 만들어 둔 객체를 가져오기
 *            사용법 : 변수위에 또는 생성자함수 위에 붙이면 가져올 수 있음
 *            (참고 : DI : 의존성 주입)
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-06         GGG          최초 생성
 */
@Service
public class DeptService {
    @Autowired
    DeptDao deptDao; // 가짜 DB에 접근하는 객체

//  TODO : 전체 조회 함수 : selectAll()(DAO 객체 함수) 호출
public List<Dept> findAll(){
//      TODO : deptDao.selectAll() : db 조회 함수 호출
        List<Dept> list = deptDao.selectAll();
        return list;
    }


}
