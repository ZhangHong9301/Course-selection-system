package com.cs.SchoolSystem.service;
import com.cs.SchoolSystem.po.Role;
/**
 * Created by asus on 2018/4/14.
 */
public interface RoleService {
    Role findByid(Integer id) throws Exception;
}
