package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.EconomeansApplication;
import com.gapjincoup.economeans.security.HttpCookieOAuth2AuthorizationRequestRepository;
import com.gapjincoup.economeans.security.config.WebSecurityConfig;
import com.gapjincoup.economeans.security.handler.OAuth2AuthenticationFailureHandler;
import com.gapjincoup.economeans.security.handler.OAuth2AuthenticationSuccessHandler;
import com.gapjincoup.economeans.security.service.CustomOAuth2UserService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        EconomeansApplication.class,
        WebSecurityConfig.class,
})
public abstract class ControllerTest {
    @MockBean
    protected CustomOAuth2UserService customOAuth2UserService;

    @MockBean
    protected OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @MockBean
    protected OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @SpyBean
    protected HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;
}