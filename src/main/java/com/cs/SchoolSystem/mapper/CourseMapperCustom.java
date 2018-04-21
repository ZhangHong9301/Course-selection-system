package com.cs.SchoolSystem.mapper;

import com.cs.SchoolSystem.po.CourseCustom;
import com.cs.SchoolSystem.po.PagingVO;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */
public interface CourseMapperCustom {
    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
