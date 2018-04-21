package com.cs.SchoolSystem.service.impl;
import com.cs.SchoolSystem.mapper.CollegeMapper;
import com.cs.SchoolSystem.po.College;
import com.cs.SchoolSystem.po.CollegeExample;
import com.cs.SchoolSystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<College> findAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();

        criteria.andCollegeidIsNotNull();


        return collegeMapper.selectByExample(collegeExample);
    }
}
