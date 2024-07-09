package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.annotations.Traced;
import com.gapjincoup.economeans.application.articles.GetArticleService;
import com.gapjincoup.economeans.dtos.ListArticleRequestDto;
import com.gapjincoup.economeans.dtos.ListArticleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
    private final GetArticleService getArticleService;

    public ArticleController(GetArticleService getArticleService) {
        this.getArticleService = getArticleService;
    }

    @GetMapping
    @Traced(spanName = "getListArticle")
    public ListArticleResponseDto getListArticle(@ModelAttribute ListArticleRequestDto requestDto) {
        return new ListArticleResponseDto(getArticleService.getListArticle(requestDto.category()));
    }
}
