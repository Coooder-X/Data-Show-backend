package com.datashow.backend.serviceImpl;

import com.datashow.backend.common.Result;
import com.datashow.backend.mapper.ArticleMapper;
import com.datashow.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Result searchArticleById(Long id) {
        return Result.success(articleMapper.selectById(id));
    }
}
