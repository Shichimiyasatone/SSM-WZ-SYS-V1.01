package cn.wz.sys.service.impl;

/**
 * 业务层，负责留言的业务
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wz.sys.dao.WordsDao;
import cn.wz.sys.entity.Words;
import cn.wz.sys.service.WordsService;

@Service
public class WordsServiceImpl implements WordsService {
    @Autowired
    WordsDao wordsDao;

    /**
     * 查询所有留言信息
     * 
     * @return 返回查询查询到的留言信息并存放到List集合中
     */
    @Override
    public List<Words> findByWords() {
        return wordsDao.findByWords();
    }

    @Override
    public void saveWords(Words words) {
        wordsDao.saveWords(words);
    }
}
