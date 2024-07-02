package com.gapjincoup.economeans.application.articles;

import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import com.gapjincoup.economeans.infrastructure.FinnhubClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArticleService {
    private final FinnhubClient finnhubClient;

    public GetArticleService(FinnhubClient finnhubClient) {
        this.finnhubClient = finnhubClient;
    }

    public List<FinnhubMarketNewsDto> getListArticle(String category) {
        return finnhubClient.getListNews(category);
    }
}
