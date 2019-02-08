package cn.wz.sys.dao;

import cn.wz.sys.entity.Admin;

public interface AdminDao {
    Admin findByName(String a_name);
    
    void insert(Admin admin);
}
