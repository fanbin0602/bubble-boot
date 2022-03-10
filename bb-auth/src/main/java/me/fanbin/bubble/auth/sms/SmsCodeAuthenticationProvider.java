package me.fanbin.bubble.auth.sms;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanbin
 * @date 2022/1/19
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    public static final String SESSION_MOBILE_KEY = "mobile";
    public static final String SESSION_SMS_CODE_KEY = "smsCode";
    public static final String FORM_MOBILE_KEY = "mobile";
    public static final String FORM_SMS_CODE_KEY = "smsCode";

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authenticationChecks(authentication);
        String mobile = authentication.getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        SmsCodeAuthenticationToken authResult = new SmsCodeAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), userDetails.getAuthorities());
        return authResult;
    }

    /**
     * 认证信息校验
     * @param authentication
     */
    private void authenticationChecks(Authentication authentication) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 表单提交的手机号和验证码
        String formMobile = request.getParameter(FORM_MOBILE_KEY);
        String formSmsCode = request.getParameter(FORM_SMS_CODE_KEY);
        // 会话中保存的手机号和验证码
        String sessionMobile = (String) request.getSession().getAttribute(SESSION_MOBILE_KEY);
        String sessionSmsCode = (String) request.getSession().getAttribute(SESSION_SMS_CODE_KEY);

        if (StringUtils.isEmpty(sessionMobile) || StringUtils.isEmpty(sessionSmsCode)) {
            throw new BadCredentialsException("为发送手机验证码");
        }

        if (!formMobile.equals(sessionMobile)) {
            throw new BadCredentialsException("手机号码不一致");
        }

        if (!formSmsCode.equals(sessionSmsCode)) {
            throw new BadCredentialsException("验证码不一致");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (SmsCodeAuthenticationToken.class.isAssignableFrom(authentication));
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
