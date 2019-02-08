package cn.wz.sys.service;

import cn.wz.common.vo.PageBean;
import cn.wz.sys.entity.Article;

/**
 * 业务层接口
 * 
 * @author Satone
 * @date 2019年2月6日下午4:57:10
 */
public interface ArticleService {
    PageBean<Article> findPageObjects(Integer startIndex, Integer pageSize, Article article);

    Article findById(Integer r_id);

    void update(Article article);

    void doSaveArticle(Article article);

    void doChangeStatus(Integer...r_id);

    void doDeleteArticle(Integer...r_id);

    void doRestoreArticle(Integer r_id);
}
