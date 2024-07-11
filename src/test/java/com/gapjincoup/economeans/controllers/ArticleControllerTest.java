package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.application.articles.GetArticleService;
import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.GraphQlTester.Response;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@GraphQlTest(ArticleController.class)
class ArticleControllerTest extends ControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    GetArticleService getArticleService;

    @Test
    @DisplayName("GET /api/v1/articles")
    void testGetListArticle() throws Exception {
        String category = "general";

        FinnhubMarketNewsDto article = new FinnhubMarketNewsDto(
                "top news", "1234567890", "Test Headline", "1", "image.jpg",
                "", "TestSource", "Test Summary", "https://test.com"
        );

        given(getArticleService.getListArticle(category))
                .willReturn(List.of(article));

        String query = """
                query {
                    getListArticle(requestDto: { category: "%s" }) {
                        articles {
                            category
                            headline
                            source
                        }
                    }
                }
                """.formatted(category);

        Response response = graphQlTester.document(query)
                .execute();

        response.path("getListArticle.articles")
                .entityList(FinnhubMarketNewsDto.class)
                .hasSize(1)
                .satisfies(articles -> {
                    FinnhubMarketNewsDto result = articles.get(0);

                    assert result.category().equals("top news");
                    assert result.headline().equals("Test Headline");
                    assert result.source().equals("TestSource");
                });

        verify(getArticleService).getListArticle(category);
    }
}