package me.fanbin.bubble.urpm.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.fanbin.bubble.urpm.api.dto.UserInfo;
import me.fanbin.bubble.urpm.api.entity.SysUser;

import java.util.List;

/**
 * 用户服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户获取用户信息
     * @param username
     * @return
     */
    UserInfo getUserInfoByUsername(String username);

}
