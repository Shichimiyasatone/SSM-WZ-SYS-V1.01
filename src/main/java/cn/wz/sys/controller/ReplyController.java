package cn.wz.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wz.sys.entity.Reply;
import cn.wz.sys.service.ReplyService;

/**
 * 控制层，留言的回复控制
 * 
 * @author Satone
 * @date 2019年2月7日下午4:18:28
 */
@Controller
@RequestMapping("reply/")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    /**
     * 保存回复信息
     */
    @RequestMapping("doSaveReply")
    public String doSaveReply(Reply reply) {
        System.out.println("ReplyController.doSaveReply()");
        System.out.println(reply);
        replyService.saveReply(reply);
        String r_id = reply.getLr_for_article_id();
        return "redirect:../article/doArticleView.do?r_id=" + r_id;
    }
}
