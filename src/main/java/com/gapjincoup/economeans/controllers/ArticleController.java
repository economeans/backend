package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.dtos.ListArticleRequestDto;
import com.gapjincoup.economeans.dtos.ListArticleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @GetMapping
    public ListArticleResponseDto getListArticle(@ModelAttribute ListArticleRequestDto requestDto) {
        return new ListArticleResponseDto(List.of());
    }
}
