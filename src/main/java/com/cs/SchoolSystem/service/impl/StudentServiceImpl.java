package com.cs.SchoolSystem.service.impl;

import com.cs.SchoolSystem.mapper.CollegeMapper;
import com.cs.SchoolSystem.mapper.StudentMapper;
import com.cs.SchoolSystem.mapper.StudentMapperCustom;
import com.cs.SchoolSystem.po.*;
import com.cs.SchoolSystem.service.StudentService;
import com.cs.SchoolSystem.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapperCustom studentMapperCustom;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public void updataById(Integer id, StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<StudentCustom> list = studentMapperCustom.findByPaging(pagingVO);
        return list;
    }

    @Override
    public Boolean save(StudentCustom studentCustoms) throws Exception {
        Student stu = studentMapper.selectByPrimaryKey(studentCustoms.getUserid());
        if (stu == null) {
            studentMapper.insert(studentCustoms);
            return true;
        }
        return false;
    }

    @Override
    public int getCountStudent() throws Exception {
        //自定义查询对象
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUseridIsNotNull();
        return (int) studentMapper.countByExample(studentExample);
    }

    @Override
    public StudentCustom findById(Integer id) throws Exception {
        Student student = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom = null;
        if (student != null){
            studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student,studentCustom);
        }
        return studentCustom;
    }

    @Override
    public List<StudentCustom> findByName(String name) throws Exception {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUsernameLike("%"+name+"%");
        List<Student> list = studentMapper.selectByExample(studentExample);
        List<StudentCustom> studentCustomList = null;
        if (list != null){
            studentCustomList = new ArrayList<StudentCustom>();
            for (Student s : list) {
                StudentCustom studentCustom = new StudentCustom();
                BeanUtils.copyProperties(s,studentCustom);
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeid());
                studentCustom.setcollegeName(college.getCollegename());
                studentCustomList.add(studentCustom);
            }
        }
        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception {
        StudentCustom studentCustom = studentMapperCustom.findStudentAndSelectCourseListById(Integer.parseInt(name));
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
        for (SelectedCourseCustom s : list){
            if (s.getMark() != null){
                s.setOver(true);
            }
        }
        return studentCustom;
    }
}
