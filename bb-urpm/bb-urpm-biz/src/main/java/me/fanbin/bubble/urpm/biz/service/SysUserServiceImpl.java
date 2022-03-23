package me.fanbin.bubble.urpm.biz.service;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import me.fanbin.bubble.urpm.api.dto.UserInfo;
import me.fanbin.bubble.urpm.api.entity.SysMenu;
import me.fanbin.bubble.urpm.api.entity.SysRole;
import me.fanbin.bubble.urpm.api.entity.SysUser;
import me.fanbin.bubble.urpm.api.service.SysMenuService;
import me.fanbin.bubble.urpm.api.service.SysRoleService;
import me.fanbin.bubble.urpm.api.service.SysUserService;
import me.fanbin.bubble.urpm.biz.mapper.SysRoleMapper;
import me.fanbin.bubble.urpm.biz.mapper.SysUserMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysRoleService roleService;
    private final SysMenuService menuService;

    /**
     * 根据用户获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserInfo getUserInfoByUsername(String username) {
        SysUser sysUser = getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        UserInfo userInfo = new UserInfo();
        // 角色列表
        List<SysRole> roleList = roleService.listByUserId(sysUser.getId());
        userInfo.setRoleList(roleList);
        // 角色 ID 列表
        List<Integer> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toList());
        userInfo.setRoles(ArrayUtil.toArray(roleIds, Integer.class));
        // 权限列表（菜单）
        Set<String> permissions = roleIds.stream()
                .map(menuService::listByRoleId)
                .flatMap(Collection::stream)
                .map(SysMenu::getPermission)
                .filter(StrUtil::isNotBlank)
                .collect(Collectors.toSet());
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        return userInfo;
    }
}
