package com.cs.SchoolSystem.service.impl;

import com.cs.SchoolSystem.mapper.CollegeMapper;
import com.cs.SchoolSystem.mapper.CourseMapper;
import com.cs.SchoolSystem.mapper.CourseMapperCustom;
import com.cs.SchoolSystem.mapper.SelectedcourseMapper;
import com.cs.SchoolSystem.po.*;
import com.cs.SchoolSystem.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseMapperCustom courseMapperCustom;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private SelectedcourseMapper selectedcourseMapper;


    @Override
    public void upadteById(Integer id, CourseCustom courseCustom) throws Exception {
        courseMapper.updateByPrimaryKey(courseCustom);
    }

    @Override
    public Boolean removeById(Integer id) throws Exception {
        //自定义查询条件
        SelectedcourseExample example = new SelectedcourseExample();
        SelectedcourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseidEqualTo(id);
        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);
        if (list.size() == 0) {
            courseMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CourseCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<CourseCustom> list = courseMapperCustom.findByPaging(pagingVO);
        return list;
    }

    @Override
    public Boolean save(CourseCustom couseCustom) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(couseCustom.getCourseid());
        if (course == null) {
            courseMapper.insert(couseCustom);
            return true;
        }
        return false;
    }

    @Override
    public int getCountCouse() throws Exception {
        //自定义查询对象
        CourseExample example = new CourseExample();
        //通过criteria构造查询条件
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andCoursenameIsNotNull();
        return (int) courseMapper.countByExample(example);
    }

    @Override
    public CourseCustom findById(Integer id) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(id);
        CourseCustom courseCustom = null;
        if (course != null) {
            courseCustom = new CourseCustom();
            BeanUtils.copyProperties(courseCustom, course);
        }
        return courseCustom;
    }

    @Override
    public List<CourseCustom> findByName(String name) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursenameLike("%" + name + "%");
        List<Course> list = courseMapper.selectByExample(courseExample);
        List<CourseCustom> courseCustomList = null;
        if (list != null) {
            courseCustomList = new ArrayList<CourseCustom>();
            for (Course c : list) {
                CourseCustom courseCustom = new CourseCustom();
                //类拷贝
                BeanUtils.copyProperties(c, courseCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(c.getCollegeid());
                courseCustom.setcollegeName(college.getCollegename());
                courseCustomList.add(courseCustom);
            }
        }
        return courseCustomList;
    }



    @Override
    public List<CourseCustom> findByTeacherID(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();
        //自定义查询条件
        CourseExample.Criteria criteria = courseExample.createCriteria();
        //根据教师id查课程
        criteria.andTeacheridEqualTo(id);

        List<Course> list = courseMapper.selectByExample(courseExample);
        List<CourseCustom> courseCustomList = null;

        if (list.size() > 0) {
            courseCustomList = new ArrayList<CourseCustom>();
            for (Course c : list) {
                CourseCustom courseCustom = new CourseCustom();
                //类拷贝
                BeanUtils.copyProperties(courseCustom, c);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(c.getCollegeid());
                courseCustom.setcollegeName(college.getCollegename());

                courseCustomList.add(courseCustom);
            }
        }

        return courseCustomList;
    }
}
