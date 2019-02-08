package cn.wz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wz.common.exception.ServiceException;
import cn.wz.common.vo.PageBean;
import cn.wz.sys.dao.ArticleDao;
import cn.wz.sys.entity.Article;
import cn.wz.sys.service.ArticleService;

/**
 * 业务层，文章业务处理
 * 
 * @author Satone
 * @date 2019年2月5日下午6:59:02
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public PageBean<Article> findPageObjects(Integer pageCode, Integer pageSize, Article article) {
        PageBean<Article> pageBean = new PageBean<Article>();

        // 封装数据
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        // 封装总记录数
        int totalCount = 0;
        totalCount = articleDao.getRowCount(article);
        pageBean.setTotalCount(totalCount);

        // 封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        // 设置limit起始位置和终止位置
        int startIndex = (pageCode - 1) * pageSize;

        // 封装每页显示的数据
        List<Article> list = articleDao.findPageObjects(startIndex, pageSize, article);
        pageBean.setBeanList(list);
        return pageBean;
    }

    public Article findById(Integer r_id) {
        if (r_id == null || r_id < 0) {
            throw new ServiceException();
        }
        return articleDao.findById(r_id);
    }

    /**
     * 更新用户信息的功能
     * 
     * @param article 需要更新的数据
     */
    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    /**
     * 添加文章信息
     * 
     * @param article 前台传来的文章数据
     */
    @Override
    public void doSaveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    /**
     * 删除文章的功能（仅把文章放入到回收站中）
     * 
     * @param r_id 需要删除的文章的ID值
     */
    @Override
    public void doChangeStatus(Integer...r_id) {
        articleDao.changeStatus(r_id);
    }

    /**
     * 删除功能
     * 
     * @param r_id 要删除字段的ID值
     */
    @Override
    public void doDeleteArticle(Integer...r_id) {
        articleDao.deleteArticle(r_id);
    }
    
    /**
     * 恢复文章的功能（即将文章从回收站中移除）
     * @param r_id 要恢复的文章的ID值
     */
    public void doRestoreArticle(Integer r_id) {
        articleDao.restoreArticle(r_id);
    }
}
