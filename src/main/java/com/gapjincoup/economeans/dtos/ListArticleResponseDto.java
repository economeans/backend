package com.gapjincoup.economeans.dtos;

import java.util.List;

public record ListArticleResponseDto(
        List<FinnhubMarketNewsDto> articles
) {
}
