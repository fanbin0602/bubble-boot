/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.fanbin.bubble.urpm.biz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.fanbin.bubble.urpm.api.entity.SysPermission;
import me.fanbin.bubble.urpm.api.service.SysMenuService;
import me.fanbin.bubble.urpm.biz.mapper.SysMenuMapper;

import java.util.List;

/**
 * @author fanbin
 * @date 2022/3/11
 */
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysPermission> implements SysMenuService {
    /**
     * 根据角色 ID 查询菜单列表
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysPermission> listByRoleId(Integer roleId) {
        return null;
    }
}
