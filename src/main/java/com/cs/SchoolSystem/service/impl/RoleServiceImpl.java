package com.cs.SchoolSystem.service.impl;

import com.cs.SchoolSystem.mapper.RoleMapper;
import com.cs.SchoolSystem.po.Role;
import com.cs.SchoolSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by asus on 2018/4/14.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
