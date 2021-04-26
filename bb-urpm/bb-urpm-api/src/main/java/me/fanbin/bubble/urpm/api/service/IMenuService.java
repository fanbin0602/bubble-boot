package me.fanbin.bubble.urpm.api.service;

import me.fanbin.bubble.urpm.api.model.SysMenu;
import me.fanbin.bubble.urpm.api.model.SysRole;

import java.util.List;

/**
 * 菜单（权限）服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface IMenuService {

    /**
     * 添加
     * @param menu 菜单
     */
    void add(SysMenu menu);

    /**
     * 修改
     * @param menu 菜单
     */
    void update(SysMenu menu);

    /**
     * 根据 id 删除菜单
     * @param id 菜单id
     */
    void deleteById(Integer id);

    /**
     * 根据 id 查找菜单
     * @param id 菜单 id
     * @return 菜单详情
     */
    SysMenu selectById(Integer id);

    /**
     * 根据角色 id 查找菜单列表
     * @param id 角色 id
     * @return 菜单列表
     */
    List<SysMenu> selectByRoleId(Integer id);

    /**
     * 根据用户 id 查找菜单列表
     * @param id 用户 id
     * @return 菜单列表
     */
    List<SysMenu> selectByUserId(Integer id);

}
