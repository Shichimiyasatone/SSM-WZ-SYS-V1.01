package cn.wz.sys.dao;

import java.util.List;

import cn.wz.sys.entity.Reply;

public interface ReplyDao {

    List<Reply> findByReply();
    
    void saveReply(Reply reply);
}
