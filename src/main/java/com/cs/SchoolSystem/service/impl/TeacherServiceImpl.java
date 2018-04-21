package com.cs.SchoolSystem.service.impl;

import com.cs.SchoolSystem.exception.CustomException;
import com.cs.SchoolSystem.mapper.CollegeMapper;
import com.cs.SchoolSystem.mapper.CourseMapper;
import com.cs.SchoolSystem.mapper.TeacherMapper;
import com.cs.SchoolSystem.mapper.TeacherMapperCustom;
import com.cs.SchoolSystem.po.*;
import com.cs.SchoolSystem.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherMapperCustom teacherMapperCustom;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public void updateById(Integer id, TeacherCustom teacherCustom) throws Exception {
        teacherMapper.updateByPrimaryKey(teacherCustom);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacheridEqualTo(id);
        List<Course> list = courseMapper.selectByExample(courseExample);
        if (list.size() != 0){
            throw new CustomException("请先删除该名老师所教授的课程");
        }
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TeacherCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<TeacherCustom> list = teacherMapperCustom.findByPaging(pagingVO);

        return list;
    }

    @Override
    public Boolean save(TeacherCustom teacherCustom) throws Exception {
        Teacher tea = teacherMapper.selectByPrimaryKey(teacherCustom.getUserid());
        if (tea == null) {
            teacherMapper.insert(teacherCustom);
            return true;
        }
        return false;
    }

    @Override
    public int getCountTeacher() throws Exception {
        //自定义查询对象
        TeacherExample teacherExample = new TeacherExample();
        //通过criteria构造查询条件
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andUseridIsNotNull();

        return (int) teacherMapper.countByExample(teacherExample);
    }

    @Override
    public TeacherCustom findById(Integer id) throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        TeacherCustom teacherCustom = null;
        if (teacher != null) {
            teacherCustom = new TeacherCustom();
            BeanUtils.copyProperties(teacher, teacherCustom);
        }

        return teacherCustom;
    }


    @Override
    public List<TeacherCustom> findByName(String name) throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        //自定义查询条件
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUsernameLike("%" + name + "%");

        List<Teacher> list = teacherMapper.selectByExample(teacherExample);

        List<TeacherCustom> teacherCustomList = null;

        if (list != null) {
            teacherCustomList = new ArrayList<TeacherCustom>();
            for (Teacher t : list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t, teacherCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(t.getCollegeid());
                teacherCustom.setcollegeName(college.getCollegename());

                teacherCustomList.add(teacherCustom);
            }
        }

        return teacherCustomList;
    }

    @Override
    public List<TeacherCustom> findAll() throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUsernameIsNotNull();

        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        List<TeacherCustom> teacherCustomsList = null;
        if (list != null) {
            teacherCustomsList = new ArrayList<TeacherCustom>();
            for (Teacher t: list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                BeanUtils.copyProperties(t, teacherCustom);
                teacherCustomsList.add(teacherCustom);
            }
        }
        return teacherCustomsList;
    }
}
