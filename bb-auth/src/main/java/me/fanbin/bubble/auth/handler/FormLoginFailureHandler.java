package me.fanbin.bubble.auth.handler;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fanbin
 * @date 2021/4/18
 */
@Slf4j
public class FormLoginFailureHandler implements AuthenticationFailureHandler {

    private static final String LOGIN_URL = "/auth/login?error=%s";

    /**
     * 跳转登录页面时，携带失败信息
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.debug("表单登录失败:{}", e.getLocalizedMessage());
        String url = HttpUtil.encodeParams(String.format(LOGIN_URL, e.getMessage()),
                CharsetUtil.CHARSET_UTF_8);
        response.sendRedirect(url);
    }
}
