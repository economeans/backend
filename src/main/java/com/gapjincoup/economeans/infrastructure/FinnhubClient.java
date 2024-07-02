package com.gapjincoup.economeans.infrastructure;

import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FinnhubClient {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public FinnhubClient(RestTemplate restTemplate, @Value("${finnhub.api_key}") String finnhubApiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = finnhubApiKey;
    }

    public List<FinnhubMarketNewsDto> getListNews(String category) {
        String baseUrl = "https://finnhub.io/api/v1/news";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("token", apiKey);
        queryParams.put("category", category);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        ResponseEntity<List<FinnhubMarketNewsDto>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }
}
