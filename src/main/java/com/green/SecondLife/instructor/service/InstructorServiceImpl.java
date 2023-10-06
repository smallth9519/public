package com.green.SecondLife.instructor.service;

import com.green.SecondLife.instructor.vo.InstructorVO;
import com.green.SecondLife.instructor.vo.SubjectVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{
    private final SqlSessionTemplate sqlSession;
    //강사 등록화면에서 강좌 과목 카테고리 조회하는 기능
    @Override
    public List<SubjectVO> selectSubjectList() {
        return sqlSession.selectList("instructorMapper.selectSubjectList");
    }
    //강사 등록 기능 + 이미지
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertInstructor(InstructorVO instructorVO) {
        sqlSession.insert("instructorMapper.insertInstructor", instructorVO);
        sqlSession.insert("instructorMapper.insertInstructorImg", instructorVO);
    }
    //강사 목록 조회 기능
    @Override
    public List<InstructorVO> selectInstuctorList() {
        return sqlSession.selectList("instructorMapper.selectInstructorList");
    }
    //강사 상세 정보 조회 기능
    @Override
    public InstructorVO selectInstructorDetail(InstructorVO instructorVO) {
        return sqlSession.selectOne("instructorMapper.selectInstructorDetail", instructorVO);
    }
    //강사 삭제 기능
    @Override
    public void deleteInstructor(InstructorVO instructorVO) {
        sqlSession.delete("instructorMapper.deleteInstructor", instructorVO);
    }
}
