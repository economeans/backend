package com.gapjincoup.economeans.dtos;

import java.util.List;

public record ArticleDetailResponseDto(
        String id,
        String title,
        List<List<String>> terms
) {
}
