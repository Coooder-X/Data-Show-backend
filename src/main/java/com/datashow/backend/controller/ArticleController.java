package com.datashow.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datashow.backend.common.Result;
import com.datashow.backend.entity.Article;
import com.datashow.backend.mapper.ArticleMapper;
import com.datashow.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Resource
    private ArticleMapper articleMapper;

    @RequestMapping("search/{id}")
    public Result searchArticleById(@PathVariable long id) {
        return articleService.searchArticleById(id);
    }

    @RequestMapping("listAll")
    public Result listAll() {
        Page<Article> page = new Page<>(1, 10);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getId);   //  按是否置顶、时间排序，等同于上面，但要注意添加的顺序
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        return Result.success(records);
//        return Result.success(articleMapper.selectList(new LambdaQueryWrapper<>()));
    }
}
