/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.fanbin.bubble.urpm.biz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.fanbin.bubble.urpm.api.entity.SysRole;
import me.fanbin.bubble.urpm.api.service.SysRoleService;
import me.fanbin.bubble.urpm.biz.mapper.SysRoleMapper;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@DubboService
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    /**
     * 根据用户 ID 查询角色列表
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    @Override
    public List<SysRole> listByUserId(Integer userId) {
        return null;
    }
}
