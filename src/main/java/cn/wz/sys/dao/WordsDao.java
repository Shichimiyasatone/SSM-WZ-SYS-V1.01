package cn.wz.sys.dao;

import java.util.List;

import cn.wz.sys.entity.Words;

public interface WordsDao {
    List<Words> findByWords();
    
    void saveWords(Words words);
}
