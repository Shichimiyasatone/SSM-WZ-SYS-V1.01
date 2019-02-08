package cn.wz.sys.service;

import cn.wz.sys.entity.Admin;

/**
 * 业务层，处理用户登录登出业务
 * @author Satone
 * @date 2019年2月5日下午4:40:18
 */
public interface AdminService {
    Admin findByName(String a_name);
    
    void doRegister(Admin admin);
}
