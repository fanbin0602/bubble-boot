package me.fanbin.bubble.urpm.api.service;

import me.fanbin.bubble.urpm.api.model.SysRole;

import java.util.List;

/**
 * 角色服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface IRoleService {

    /**
     * 添加
     * @param role 角色信息
     */
    void add(SysRole role);

    /**
     * 修改
     * @param role 角色信息
     */
    void update(SysRole role);

    /**
     * 根据 id 删除角色信息
     * @param id 角色 id
     */
    void deleteById(Integer id);

    /**
     * 根据 id 查找角色信息
     * @param id 角色 id
     * @return 角色信息
     */
    SysRole selectById(Integer id);

    /**
     * 根据用户 id 查询角色列表
     * @param id 用户 id
     * @return 角色列表
     */
    List<SysRole> selectByUserId(Integer id);

    /**
     * 更新角色的菜单（权限）列表
     * @param ids 菜单 id 数组
     */
    void updateMenuList(Integer[] ids);

}
