package me.fanbin.bubble.auth.sms;

import cn.hutool.extra.spring.SpringUtil;
import lombok.RequiredArgsConstructor;
import me.fanbin.bubble.auth.service.BubbleUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.context.SpringContextUtils;

/**
 * @author fanbin
 * @date 2022/1/19
 */
@Component
@RequiredArgsConstructor
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) {

        SmsCodeAuthenticationProcessingFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationProcessingFilter();
        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(new SmsCodeAuthenticationSuccessHandler());
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(new SmsCodeAuthenticationFailureHandler());
        SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(smsCodeAuthenticationProvider)
                .addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
