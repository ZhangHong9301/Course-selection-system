package com.cs.SchoolSystem.mapper;

import com.cs.SchoolSystem.po.PagingVO;
import com.cs.SchoolSystem.po.StudentCustom;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */
public interface StudentMapperCustom {
    //分页查询学生信息
    List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception;
    //查询学生信息和其选课信息
    StudentCustom findStudentAndSelectCourseListById(Integer id) throws Exception;
}
