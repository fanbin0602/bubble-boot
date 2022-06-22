package me.fanbin.bubble.urpm.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import me.fanbin.bubble.urpm.api.dto.UserInfo;
import me.fanbin.bubble.urpm.api.entity.SysUser;

/**
 * 用户服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo getUserInfoByUsername(String username);

    /**
     * 添加用户
     * @param user 用户信息
     * @return 成功与否
     */
    Integer addUser(SysUser user);

    /**
     * 分页查询 SysUser 对象
     * @param page 分页信息
     * @param conditions 查询条件
     * @return 查询结果
     */
    IPage<SysUser> pageUser(Page<SysUser> page, SysUser conditions);

}
