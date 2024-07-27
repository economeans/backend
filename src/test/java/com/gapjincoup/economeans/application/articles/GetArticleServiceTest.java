package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import com.gapjincoup.economeans.repositories.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetArticleServiceTest {
    private GetArticleService getArticleService;
    private FinnhubClient finnhubClient;
    private ArticleRepository articleRepository;

    @BeforeEach
    void setUp() {
        finnhubClient = mock(FinnhubClient.class);
        articleRepository = mock(ArticleRepository.class);

        getArticleService = new GetArticleService(finnhubClient, articleRepository);
    }

    @Test
    void testGetListArticle() {
        String category = "category";

        getArticleService.getListArticle(category);

        verify(finnhubClient).getListNews(category);
    }
}