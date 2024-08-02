package com.gapjincoup.economeans.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "economeans.frontend.host")
public class JwtTokenConstants {
    private String host;
}
