package cn.wz.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller，用于首页跳转
 * @author Satone
 * @date 2019年2月5日下午4:18:31
 */

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("{path}.do")
    public String doIndexUI(@PathVariable("path")String path) {
        return "index";
    }
}
