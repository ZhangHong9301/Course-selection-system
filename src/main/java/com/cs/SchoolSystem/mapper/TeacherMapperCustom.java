package com.cs.SchoolSystem.mapper;

import com.cs.SchoolSystem.po.PagingVO;
import com.cs.SchoolSystem.po.TeacherCustom;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */
public interface TeacherMapperCustom {
    //分页查询老师信息
    List<TeacherCustom> findByPaging(PagingVO pagingVO) throws Exception;

}
