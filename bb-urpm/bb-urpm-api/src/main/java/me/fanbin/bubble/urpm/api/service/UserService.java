package me.fanbin.bubble.urpm.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.fanbin.bubble.urpm.api.model.SysUser;

import java.util.List;

/**
 * 用户服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface UserService {

    /**
     * 添加
     * @param user 用户信息
     */
    void add(SysUser user);

    /**
     * 修改
     * @param user 用户信息
     */
    void update(SysUser user);

    /**
     * 根据 id 删除
     * @param id 用户 id
     */
    void deleteById(Integer id);

    /**
     * 根据 id 查找
     * @param id 用户 id
     */
    void selectById(Integer id);

    /**
     * 根据角色查询用户列表
     * @param id 角色 id
     * @return 用户列表
     */
    List<SysUser> selectByRoleId(Integer id);

    /**
     * 更新用户的角色列表
     * @param ids 角色 id 数组
     */
    void updateRoleList(Integer[] ids);

    /**
     * 根据条件查询列表
     * @param user 查询条件
     * @return 查询结果
     */
    List<SysUser> selectList(SysUser user);

    /**
     * 根据条件查询分页
     * @param page 分页信息
     * @param user 查询条件
     * @return 查询结果
     */
    IPage<SysUser> selectPage(Page page, SysUser user);

}
