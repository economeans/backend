package com.gapjincoup.economeans.infrastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EcosClientTest {
    @Mock
    private EcosClient ecosClient;

    @Mock
    private RestTemplate restTemplate;


    @Test
    void getTerms() {

        String baseUrl = "https://ecos.bok.or.kr/api/StatisticWord/FFMI99QPYH9TBZQU6JS2/json/kr/1/10/소비자동향지수";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);

        ResponseEntity<Object> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        ResponseEntity<Objects> terms = ecosClient.getTerms(
                "StatisticWord",
                "FFMI99QPYH9TBZQU6JS2",
                "json",
                "kr",
                1,
                10,
                "소비자동향지수"
        );
    }
}