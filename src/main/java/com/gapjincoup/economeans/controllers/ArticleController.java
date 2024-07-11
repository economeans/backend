package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.application.articles.GetArticleService;
import com.gapjincoup.economeans.dtos.ListArticleRequestDto;
import com.gapjincoup.economeans.dtos.ListArticleResponseDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {
    private final GetArticleService getArticleService;

    public ArticleController(GetArticleService getArticleService) {
        this.getArticleService = getArticleService;
    }

    @QueryMapping
    public ListArticleResponseDto getListArticle(@Argument ListArticleRequestDto requestDto) {
        return new ListArticleResponseDto(getArticleService.getListArticle(requestDto.category()));
    }
}
