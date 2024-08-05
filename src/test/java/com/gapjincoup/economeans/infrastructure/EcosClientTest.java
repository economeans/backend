package com.gapjincoup.economeans.infrastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EcosClientTest {
    @Mock
    private EcosClient ecosClient;

    @Mock
    private RestTemplate restTemplate;


    @Test
    void getTerms() {

        String baseUrl = "https://ecos.bok.or.kr/api/StatisticWord/FFMI99QPYH9TBZQU6JS2/json/kr/1/10/소비자동향지수";

        String uriString = UriComponentsBuilder.fromHttpUrl(baseUrl).encode().toUriString();

        ResponseEntity<Objects> forEntity = restTemplate.getForEntity(uriString, Objects.class);
    }

    @Test
    void makeBaseUri() {
        String baseUrl = "https://ecos.bok.or.kr/api";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment("StatisticWord")
                .pathSegment("FFMI99QPYH9TBZQU6JS2")
                .pathSegment("json")
                .pathSegment("kr")
                .pathSegment(String.valueOf(1))
                .pathSegment(String.valueOf(10))
                .pathSegment("소비자동향지수");

        assertEquals(builder.toUriString(), "https://ecos.bok.or.kr/api/StatisticWord/FFMI99QPYH9TBZQU6JS2/json/kr/1/10/%EC%86%8C%EB%B9%84%EC%9E%90%EB%8F%99%ED%96%A5%EC%A7%80%EC%88%98");
    }
}