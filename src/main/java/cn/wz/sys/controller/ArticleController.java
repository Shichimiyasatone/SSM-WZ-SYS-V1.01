package cn.wz.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wz.sys.entity.Article;
import cn.wz.sys.entity.Reply;
import cn.wz.sys.entity.Words;
import cn.wz.sys.service.ArticleService;
import cn.wz.sys.service.ReplyService;
import cn.wz.sys.service.WordsService;

/**
 * 控制器，控制文字展示
 * 
 * @author Satone
 * @date 2019年2月5日下午6:06:02
 */

@Controller
@RequestMapping("article/")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ReplyService replyService;
    @Autowired
    WordsService wordsService;

    /**
     * 跳转到文章管理页面
     */
    @RequestMapping("findByPage")
    public String findByPage(Article article, @RequestParam(defaultValue = "1", required = false) int pageCode,
            @RequestParam(defaultValue = "3", required = false) int pageSize, HttpServletRequest request, Model model) {
        System.out.println(article.getR_status());
        // 回显数据
        model.addAttribute("page", articleService.findPageObjects(pageCode, pageSize, article));
        if (article.getR_status()!=null&&article.getR_status() == 1) {
            return "/view/article/articleTrash";
        }
        return "view/article/articleManage";
    }

    /**
     * 跳转到查看文章内容页面
     */
    // 声明用于存放留言回复信息的List集合
    @RequestMapping("doArticleView")
    public String doArticleView(Integer r_id, Model model) {
        List<Words> lw_list;
        List<Reply> lr_list;
        // 封装留言信息
        lw_list = wordsService.findByWords();
        model.addAttribute("lw_list", lw_list);

        // 封装回复信息
        lr_list = replyService.findByReply();
        model.addAttribute("lr_list", lr_list);

        // 查询文章信息
        Article article = articleService.findById(r_id);
        System.out.println("查询到当前文章的ID值：" + article.getR_id());
        model.addAttribute("article", article);
        return "view/article/articleView";
    }

    /**
     * 更新文章信息的方法
     */
    @RequestMapping("doArticleEdit")
    public String doArticleEdit(Integer r_id, Model model) {
        Article article = articleService.findById(r_id);
        if (article != null) {
            model.addAttribute("article", article);
            return "view/article/articleUpdate";
        } else {
            model.addAttribute("message", "文章信息获取失败");
            return "view/info/message";
        }
    }

    /**
     * 保存文章
     */
    @RequestMapping("doSaveArticle")
    public String doSaveArticle(Article article, Model model) {
        articleService.doSaveArticle(article);
        model.addAttribute("message", "文章添加成功");
        return "view/info/message";
    }

    /**
     * 更新文章信息的方法
     */
    @RequestMapping("doUpdateArticle")
    public String doUpdateArticle(Article article, Model model) {
        if (article != null) {
            articleService.update(article);
            return "redirect:findByPage.do";
        } else {
            model.addAttribute("message", "文章信息获取失败");
            return "view/info/message";
        }
    }

    /**
     * 文章删除（仅放入回收站，即仅仅改变status的值）
     */
    @RequestMapping("doDeleteAritcle")
    public String doDeleteAritcle(Integer r_id) {
        articleService.doChangeStatus(r_id);
        return "redirect:findByPage.do";
    }

    /**
     * 跳转到文章编辑页面
     */
    @RequestMapping("doArticleWrite")
    public String doArticleWrite() {
        return "view/article/articleWrite";
    }

    /**
     * 跳转到回收站页面
     */
    @RequestMapping("doArticleTrash")
    public String doArticleTrash(Model model) {
        model.addAttribute("r_status", 1);
        return "redirect:findByPage.do";
    }
    
    /**
     * 删除功能
     */
    @RequestMapping("doDeleteArticle")
    public String doDeleteArticle(@RequestParam int r_id) {
        articleService.doDeleteArticle(r_id);
        return "redirect:findByPage.do";
    }
    
    /**
     * 恢复文章信息功能（即将文章从回收站中取出，改变status值）
     */
    @RequestMapping("doRestoreArticle")
    public String doRestoreArticle(Integer r_id) {
        articleService.doRestoreArticle(r_id);
        return "redirect:findByPage.do";
    }
}
