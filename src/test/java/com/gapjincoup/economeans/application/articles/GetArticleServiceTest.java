package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.dtos.ArticleDetailResponseDto;
import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import com.gapjincoup.economeans.models.Article;
import com.gapjincoup.economeans.models.ArticleId;
import com.gapjincoup.economeans.repositories.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    @Test
    @DisplayName("존재하는 기사 상세 요청")
    void getExistingArticleDetail() {
        String articleId = "123";
        Article mockArticle = new Article(new ArticleId(articleId), "Title", "[]");
        given(articleRepository.findById(any(ArticleId.class))).willReturn(Optional.of(mockArticle));

        ArticleDetailResponseDto result = getArticleService.getArticleDetail(articleId);

        assertNotNull(result);
        assertEquals(mockArticle.id().toString(), result.id());
        assertEquals(mockArticle.title(), result.title());
        assertEquals(mockArticle.terms(), result.terms());

        verify(articleRepository).findById(any(ArticleId.class));
    }

    @Test
    @DisplayName("존재하지 않는 기사 상세 요청")
    void getNonExistentArticleDetail() {
        String articleId = "non-existent";
        given(articleRepository.findById(any(ArticleId.class))).willReturn(Optional.empty());

        assertThatThrownBy(() -> getArticleService.getArticleDetail(articleId))
                .isInstanceOf(NoSuchElementException.class);

        verify(articleRepository).findById(any(ArticleId.class));
    }
}