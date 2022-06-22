package me.fanbin.bubble.auth.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.fanbin.bubble.auth.service.BubbleClientDetailsService;
import me.fanbin.bubble.auth.sms.ResourceOwnerSmsTokenGranter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanbin
 * @date 2021/4/18
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
@Slf4j
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    /**
     * OAuth 客户端配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        BubbleClientDetailsService bubbleClientDetailsService = new BubbleClientDetailsService(dataSource);
        clients.withClientDetails(bubbleClientDetailsService);
    }

    /**
     * 安全配置
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // client_secret 以表单方式提交
        // security.allowFormAuthenticationForClients();
        // 打开验证 token 的访问权限 /oauth/check_token
        security.checkTokenAccess("permitAll()");
        // 开启验证端口无权限访问 /oauth/token_key
        // security.tokenKeyAccess("permitAll()");
    }

    /**
     * 授权节点配置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置用户认证服务 @See BubbleUserDetailsServiceImpl
        endpoints.userDetailsService(userDetailsService);
        // 由于密码模式包含认证环节，因此需要配置认证管理器（这里使用的是默认实现）
        // @See WebSecurityConfigurer#authenticationManagerBean()
        endpoints.authenticationManager(authenticationManager);

        //
        endpoints.tokenGranter(tokenGranter(endpoints));
    }

    /**
     * OAuth TokenGranter 列表，在默认模式基础上增加短信验证码模式
     * @param endpoints
     * @return
     */
    private TokenGranter tokenGranter(AuthorizationServerEndpointsConfigurer endpoints) {

        List<TokenGranter> tokenGranters = new ArrayList<>();

        tokenGranters.add(endpoints.getTokenGranter());

        /** 默认的授权码模式
        // 授权码模式
        tokenGranters.add(new AuthorizationCodeTokenGranter(
                endpoints.getTokenServices(),
                endpoints.getAuthorizationCodeServices(),
                endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory()));

        // 刷新令牌模式
        tokenGranters.add(new RefreshTokenGranter(
                endpoints.getTokenServices(),
                endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory()));

        // 简化模式
        tokenGranters.add(new ImplicitTokenGranter(
                endpoints.getTokenServices(),
                endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory()));

        // 客户端模式
        tokenGranters.add(new ClientCredentialsTokenGranter(
                endpoints.getTokenServices(),
                endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory()));

        // 密码模式
        if (authenticationManager != null) {
            tokenGranters.add(new ResourceOwnerPasswordTokenGranter(
                    authenticationManager,
                    endpoints.getTokenServices(),
                    endpoints.getClientDetailsService(),
                    endpoints.getOAuth2RequestFactory()));
        }
         */

        tokenGranters.add(new ResourceOwnerSmsTokenGranter(
                authenticationManager,
                endpoints.getTokenServices(),
                endpoints.getClientDetailsService(),
                endpoints.getOAuth2RequestFactory()));

        return new CompositeTokenGranter(tokenGranters);
    }
}

