package cn.wz.sys.dao;
/**
 * 负责文章的查找
 * @author Satone
 * @date 2019年2月5日下午6:17:30
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wz.sys.entity.Article;

public interface ArticleDao {
    List<Article> findPageObjects(@Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize,@Param("article")Article article);
    
    int getRowCount(@Param("article")Article article);
    
    Article findById(int r_id);
    
    void update(Article article);
    
    void saveArticle(Article article);
    
    void deleteArticle(@Param("ids")Integer...ids);
    
    void changeStatus(@Param("ids")Integer...ids);
    
    void restoreArticle(int r_id);
}
