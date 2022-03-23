package me.fanbin.bubble.urpm.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.fanbin.bubble.urpm.api.entity.SysRole;

import java.util.List;

/**
 * 角色服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户 ID 查询角色列表
     * @param userId
     * @return
     */
    List<SysRole> listByUserId(Integer userId);
}
