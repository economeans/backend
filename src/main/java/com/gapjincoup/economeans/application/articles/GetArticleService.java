package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.dtos.ArticleDetailResponseDto;
import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import com.gapjincoup.economeans.models.Article;
import com.gapjincoup.economeans.models.ArticleId;
import com.gapjincoup.economeans.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GetArticleService {
    private final FinnhubClient finnhubClient;
    private final ArticleRepository articleRepository;

    public GetArticleService(FinnhubClient finnhubClient, ArticleRepository articleRepository) {
        this.finnhubClient = finnhubClient;
        this.articleRepository = articleRepository;
    }

    public List<FinnhubMarketNewsDto> getListArticle(String category) {
        return finnhubClient.getListNews(category);
    }

    public ArticleDetailResponseDto getArticleDetail(String articleId) {
        Article found = articleRepository
                .findById(new ArticleId(articleId))
                .orElseThrow(NoSuchElementException::new);

        return ArticleDetailResponseDto.of(found);
    }
}
