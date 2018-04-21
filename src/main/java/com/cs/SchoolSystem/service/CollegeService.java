package com.cs.SchoolSystem.service;

import com.cs.SchoolSystem.po.College;

import java.util.List;

/**
 * Created by asus on 2018/4/13.
 */
public interface CollegeService {
    List<College> findAll() throws Exception;
}
