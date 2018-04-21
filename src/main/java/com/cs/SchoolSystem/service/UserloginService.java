package com.cs.SchoolSystem.service;

import com.cs.SchoolSystem.po.Userlogin;

/**
 * Created by asus on 2018/4/14.
 */
public interface UserloginService {
    //根据名字查找用户
    Userlogin findByName(String name) throws Exception;

    //保存用户登录信息
    void save(Userlogin userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;

    //根据用户名更新
    void updateByName(String name, Userlogin userlogin);
}
