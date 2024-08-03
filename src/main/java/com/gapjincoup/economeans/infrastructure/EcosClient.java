package com.gapjincoup.economeans.infrastructure;

import com.gapjincoup.economeans.dtos.FinnhubMarketNewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RequiredArgsConstructor
public class EcosClient {
    private final RestTemplate restTemplate;

    public ResponseEntity<Objects> getTerms(
            String service,
            String key,
            String reqType,
            String locale,
            Integer reqStart,
            Integer reqEnd,
            String keyword
    ) {
        String baseUrl = "https://ecos.bok.or.kr/api";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(service)
                .pathSegment(key)
                .pathSegment(reqType)
                .pathSegment(locale)
                .pathSegment(String.valueOf(reqStart))
                .pathSegment(String.valueOf(reqEnd))
                .pathSegment(keyword);

        return restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
    }
}
