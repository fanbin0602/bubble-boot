package me.fanbin.bubble.urpm.api.entity;

import java.io.Serializable;

/**
 * 角色-菜单（多对多）
 * @author fanbin
 * @date 2021/4/23
 */
public class SysRolePermission implements Serializable {

    private Integer roleId;
    private Integer permissionId;

}
