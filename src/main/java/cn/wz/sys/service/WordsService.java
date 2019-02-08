package cn.wz.sys.service;

import java.util.List;

import cn.wz.sys.entity.Words;

public interface WordsService {

    List<Words> findByWords();

    void saveWords(Words words);
}
