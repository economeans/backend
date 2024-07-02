package com.gapjincoup.economeans.infrastructure;

import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinnhubClient {
    public List<FinnhubMarketNewsDto> getListNews(String category) {
        return List.of();
    }
}
