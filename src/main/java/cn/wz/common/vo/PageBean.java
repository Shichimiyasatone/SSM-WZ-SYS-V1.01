package cn.wz.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 封装查询结果
 * 
 * @author Satone
 * @date 2019年2月5日下午7:06:31
 */
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = -5266613577829092718L;

    // 当前页
    private int pageCode;

    // 总页数=总条数/每页显示的条数
    private int totalPage;

    // 总记录数
    private int totalCount;

    // 每页显示的记录条数
    private int pageSize;

    // 每页显示的记录条数
    private List<T> beanList;

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}