package com.example.modelexam.controller.exam11;

import com.example.modelexam.model.Dept;
import com.example.modelexam.service.exam11.Dept11Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.controller.exam07
 * fileName : Dept07Controller
 * author : GGG
 * date : 2023-10-11
 * description : @RestController + react 연동(vue 등)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-11         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam11")
public class Dept11Controller {
    //  TODO : 객체 가져오기
    @Autowired
    Dept11Service deptService;

    /**
     * 전체 조회 함수
     */
    @GetMapping("/dept")
    public ResponseEntity<Object> getDeptAll() {
        try {
            List<Dept> list = deptService.findAll();
            if (list.isEmpty() == false) {
//           TODO : 조회 성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//            TODO : 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
//        TODO : INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 상세 조회(1건 조회) 함수
     */
    @GetMapping("/dept/{dno}")
    public ResponseEntity<Object> getDeptId(@PathVariable long dno){
        try {
            Optional<Dept> optionalDept = deptService.findById(dno);
            if (optionalDept.isEmpty() == false) {
//           TODO : 조회 성공
                return new ResponseEntity<>(optionalDept.get(), HttpStatus.OK);
            } else {
//            TODO : 데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
//        TODO : INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 저장 함수
     */

    @PostMapping("/dept")
    public ResponseEntity<Object> createDept(@RequestBody Dept dept){
        try{
            List<Dept> list = deptService.save(dept);
            return new ResponseEntity<>(list,HttpStatus.CREATED);

        }catch (Exception e){
            log.debug(e.getMessage());
//          TODO : INTERNAL_SERVER_ERROR(500) : sql 구문 에러 등
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정 함수
     */
    @PutMapping("/dept/edit/{dno}")
    public ResponseEntity<Object> updateDept(@PathVariable int dno, @RequestBody Dept dept){
        try{
            List<Dept> list = deptService.save(dept);
            return new ResponseEntity<>(list,HttpStatus.CREATED);

        }catch (Exception e){
            log.debug(e.getMessage());
//          TODO : INTERNAL_SERVER_ERROR(500) : sql 구문 에러 등
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 삭제 함수
     */

    @DeleteMapping("/dept/delete/{dno}")
    public ResponseEntity<Object> deleteDept(@PathVariable int dno){
        try {
            boolean bSuccess = deptService.removeById(dno);
            if (bSuccess == true) {
//           TODO : 삭제 성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//            TODO : 0건 삭제 (없음)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
//        TODO : INTERNAL_SERVER_ERROR(500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }

