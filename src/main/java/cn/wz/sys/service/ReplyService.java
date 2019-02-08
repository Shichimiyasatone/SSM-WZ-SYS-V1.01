package cn.wz.sys.service;

import java.util.List;

import cn.wz.sys.entity.Reply;

public interface ReplyService {

    List<Reply> findByReply();
    
    void saveReply(Reply reply);
}
