package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetArticleServiceTest {
    private GetArticleService getArticleService;
    private FinnhubClient finnhubClient;

    @BeforeEach
    void setUp() {
        finnhubClient = mock(FinnhubClient.class);

        getArticleService = new GetArticleService(finnhubClient);
    }

    @Test
    void testGetListArticle() {
        String category = "category";

        getArticleService.getListArticle(category);

        verify(finnhubClient).getListNews(category);
    }
}