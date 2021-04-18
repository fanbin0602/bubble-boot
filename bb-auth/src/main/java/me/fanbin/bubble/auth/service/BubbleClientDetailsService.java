package me.fanbin.bubble.auth.service;

import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * JdbcClientDetailsService 扩展
 * @author fanbin
 * @date 2021/4/18
 */
public class BubbleClientDetailsService extends JdbcClientDetailsService {

    public BubbleClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * //TODO: 暂时维持原样，之后添加方法级缓存
     * @param clientId
     * @return
     * @throws InvalidClientException
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        return super.loadClientByClientId(clientId);
    }
}
