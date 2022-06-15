package me.fanbin.bubble.urpm.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.fanbin.bubble.urpm.api.entity.SysPermission;

import java.util.List;

/**
 * 菜单（权限）服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface SysMenuService extends IService<SysPermission> {

    /**
     * 根据角色 ID 查询菜单列表
     * @param roleId
     * @return
     */
    List<SysPermission> listByRoleId(Integer roleId);
}
