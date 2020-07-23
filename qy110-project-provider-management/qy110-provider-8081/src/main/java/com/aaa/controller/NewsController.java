package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.News;
import com.aaa.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController extends CommonController {

    @Autowired
    private NewsService newsService;

    @Override
    public BaseService getBaseService() {
        return newsService;
    }
    @GetMapping("/selectAllNews")
    public ResultData selectAllNews(){
        List<News> news = newsService.selectAll();
        if (news.size() > 0 && news != null){
            return selectSuccess(news);
        }else {
            return selectFailed();
        }
    }
}
