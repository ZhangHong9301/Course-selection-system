package com.cs.SchoolSystem.controller;

import com.cs.SchoolSystem.exception.CustomException;
import com.cs.SchoolSystem.po.Userlogin;
import com.cs.SchoolSystem.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import javax.annotation.Resource;
import java.util.Currency;

/**
 * Created by asus on 2018/4/14.
 */
@Controller
public class RestPasswordController {
    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;
    //本帐户密码重置
    @RequestMapping(value = "/passwordRest",method = {RequestMethod.POST})
    public String passwordRest(String oldPassword,String password1) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Userlogin userlogin = userloginService.findByName(username);
        if (!oldPassword.equals(userlogin.getPassword())){
            throw new CustomException("旧密码不正确");
        }else {
            userlogin.setPassword(password1);
            userloginService.updateByName(username,userlogin);
        }
        return "redirect:/logout";
    }
}
