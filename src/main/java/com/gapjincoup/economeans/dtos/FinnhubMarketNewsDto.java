package com.gapjincoup.economeans.dtos;

public record FinnhubMarketNewsDto(
        String category, // News category.
        String datetime, // Published time in UNIX timestamp.
        String headline, // News headline.
        String id, // News ID. This value can be used for minId params to get the latest news only.
        String image, // Thumbnail image URL.
        String related, // Related stocks and companies mentioned in the article.
        String source, // News source.
        String summary, // News summary.
        String url // URL of the original article.
) {
}
