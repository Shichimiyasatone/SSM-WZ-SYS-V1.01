package cn.wz.sys.service.impl;
/**
 * 业务层，负责回复业务
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wz.sys.dao.ReplyDao;
import cn.wz.sys.entity.Reply;
import cn.wz.sys.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    ReplyDao replyDao;
    
    /**
     * 查询所有的回复信息
     * 
     * @return 返回查询到的回复信息并存放到List集合中
     */
    @Override
    public List<Reply> findByReply() {
        return replyDao.findByReply();
    }
    
    @Override
    public void saveReply(Reply reply) {
        replyDao.saveReply(reply);
    }
}
