package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.EconomeansApplication;
import com.gapjincoup.economeans.security.WebSecurityConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        EconomeansApplication.class,
        WebSecurityConfig.class,
})
public abstract class ControllerTest {
}