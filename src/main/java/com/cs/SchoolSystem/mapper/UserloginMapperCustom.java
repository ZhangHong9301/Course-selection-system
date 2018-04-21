package com.cs.SchoolSystem.mapper;

import com.cs.SchoolSystem.po.UserloginCustom;

/**
 * Created by asus on 2018/4/14.
 */
public interface UserloginMapperCustom {
    UserloginCustom findOneByName(String name) throws Exception;
}
