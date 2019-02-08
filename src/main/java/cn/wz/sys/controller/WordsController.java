package cn.wz.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wz.sys.entity.Words;
import cn.wz.sys.service.WordsService;

/**
 * 控制层，留言请求控制
 * 
 * @author Satone
 * @date 2019年2月7日下午3:56:04
 */
@Controller
@RequestMapping("words/")
public class WordsController {
    @Autowired
    WordsService wordsService;

    /**
     * 保存留言信息
     */
    @RequestMapping("doSaveWords")
    public String saveWords(Words words) {
        String r_id = words.getLw_for_article_id();
        wordsService.saveWords(words);
        return "redirect:../article/doArticleView.do?r_id=" + r_id;
    }
}
