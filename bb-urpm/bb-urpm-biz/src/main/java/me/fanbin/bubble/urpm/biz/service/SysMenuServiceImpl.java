package me.fanbin.bubble.urpm.biz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.fanbin.bubble.urpm.api.entity.SysPermission;
import me.fanbin.bubble.urpm.api.service.SysMenuService;
import me.fanbin.bubble.urpm.biz.mapper.SysMenuMapper;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@DubboService
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysPermission> implements SysMenuService {
    /**
     * 根据角色 ID 查询菜单列表
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    @Override
    public List<SysPermission> listByRoleId(Integer roleId) {
        return null;
    }
}
