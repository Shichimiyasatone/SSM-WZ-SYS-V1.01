package cn.wz.sys.entity;

import java.io.Serializable;

/**
 * 映射数据库的admin表
 * 
 * @author Satone
 * @date 2019年2月5日下午4:31:20
 */
public class Admin implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5890340459046346181L;
    // ID编号
    private int a_id;
    // 用户名
    private String a_name;
    // 密码
    private String a_password;
    // 联系电话
    private String a_telephone;
    // 加密盐值
    private String a_salt;

    public String getA_salt() {
        return a_salt;
    }

    public void setA_salt(String a_salt) {
        this.a_salt = a_salt;
    }

    @Override
    public String toString() {
        return "Admin [a_id=" + a_id + ", a_name=" + a_name + ", a_password=" + a_password + ", a_telephone="
                + a_telephone + ", a_date=" + a_date + "]";
    }

    // 注册日期
    private String a_date;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_telephone() {
        return a_telephone;
    }

    public void setA_telephone(String a_telephone) {
        this.a_telephone = a_telephone;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }
}
