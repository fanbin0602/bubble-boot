package me.fanbin.bubble.auth.service;

import lombok.RequiredArgsConstructor;
import me.fanbin.bubble.auth.domain.BubbleUser;
import me.fanbin.bubble.urpm.api.entity.SysUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author fanbin
 * @date 2021/4/18
 */
@Service
@RequiredArgsConstructor
public class BubbleUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 从 URPM 读取用户信息
        SysUser sysUser = new SysUser();

        // TODO: 临时逻辑，之后对接用户管理相关的服务
        // return new User(username, passwordEncoder.encode("123456"), AuthorityUtils.createAuthorityList("admin"));
        return new User(username, "123456", AuthorityUtils.createAuthorityList("admin"));
    }

    private UserDetails getUserDetails() {
        return null;
    }

}
