package com.cs.SchoolSystem.service.impl;

import com.cs.SchoolSystem.mapper.UserloginMapper;
import com.cs.SchoolSystem.po.Userlogin;
import com.cs.SchoolSystem.po.UserloginCustom;
import com.cs.SchoolSystem.po.UserloginExample;
import com.cs.SchoolSystem.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/4/14.
 */
@Service
public class UserloginServiceImpl implements UserloginService{
    @Autowired
    private UserloginMapper userloginMapper;


    @Override
    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<Userlogin> list = userloginMapper.selectByExample(userloginExample);
        return list.get(0);
    }

    @Override
    public void save(Userlogin userlogin) throws Exception {
        userloginMapper.insert(userlogin);
    }

    @Override
    public void removeByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.deleteByExample(userloginExample);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }
}
