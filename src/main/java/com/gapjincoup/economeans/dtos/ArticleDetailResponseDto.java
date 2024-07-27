package com.gapjincoup.economeans.dtos;

import com.gapjincoup.economeans.models.Article;

import java.util.List;

public record ArticleDetailResponseDto(
        String id,
        String title,
        List<List<String>> terms
) {
    public static ArticleDetailResponseDto of(Article article) {
        return new ArticleDetailResponseDto(
                article.id().toString(),
                article.title(),
                article.terms()
        );
    }
}
