package cn.wz.sys.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wz.sys.entity.Admin;
import cn.wz.sys.service.AdminService;

/**
 * 用户控制器，用于登录验证
 * @author Satone
 * @date 2019年2月5日下午4:28:52
 */

@Controller
@RequestMapping("admin/")
public class AdminController {
    @Autowired
    AdminService adminService;
    
    @ResponseBody
    @RequestMapping("isExist")
    public Admin isExist(String a_name) {
        Admin info = adminService.findByName(a_name);
        System.out.println(info);
        return info;
    }
    /**
     * 以用户名查找admin表，是否存在该用户
     *  @param a_name
     *  @return
     */
    @ResponseBody
    @RequestMapping("findByName")
    public Admin findByName(String a_name) {
        Admin info = adminService.findByName(a_name);
        return info;
    }
    
    /**
     * 登录功能
     *  @param a_name
     *  @param a_password
     *  @param model
     *  @param session
     *  @return
     */
    @RequestMapping("login")
    public String logIn(String a_name,String a_password, Model model, HttpSession session) {
        Admin admin = adminService.findByName(a_name);
        if (admin != null) {
            // 获取盐值
            String salt = admin.getA_salt();
            // 与盐值拼接，生成密文
            SimpleHash sHash = new SimpleHash("MD5", a_password, salt);
            // 密文比较
            if (admin.getA_password().equals(sHash.toString())) {
                session.setAttribute("name", admin.getA_name());
                return "view/page";
            } else {
                model.addAttribute("message", "用户名或密码错误");
                return "view/login/info";
            }
        } else {
            model.addAttribute("message", "登录失败");
            return "view/login/info";
        }
    }
    
    /**
     * 退出登录的功能
     */
    @RequestMapping("doLogOut")
    public String doLogOut(HttpSession session) {
        session.invalidate();
        return "index";
    }
    
    /**
     * 注册功能
     */
    @RequestMapping("doRegister")
    public String doRegister(Admin admin, HttpSession session) {
        adminService.doRegister(admin);
        session.setAttribute("name", admin.getA_name());
        return "view/page";
    }
}
