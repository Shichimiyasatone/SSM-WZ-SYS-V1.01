package cn.wz.sys.service.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wz.common.exception.ServiceException;
import cn.wz.sys.dao.AdminDao;
import cn.wz.sys.entity.Admin;
import cn.wz.sys.service.AdminService;

/**
 * 实现用户业务
 * 
 * @author Satone
 * @date 2019年2月5日下午4:41:53
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin findByName(String a_name) {
        if (a_name == null || a_name.equals("")) {
            throw new ServiceException("用户名为空");
        }
        return adminDao.findByName(a_name);
    }

    /**
     * 注册功能
     *
     * @param admin 注册的信息
     * @return 返回影响的行数
     */
    @Override
    public void doRegister(Admin admin) {
        // 随机生成盐值，增加密码复杂度
        String salt = UUID.randomUUID().toString();
        admin.setA_salt(salt);
        // 加密
        SimpleHash sHash = new SimpleHash("MD5", admin.getA_password(), salt);
        admin.setA_password(sHash.toString());
        adminDao.insert(admin);
    }
}
