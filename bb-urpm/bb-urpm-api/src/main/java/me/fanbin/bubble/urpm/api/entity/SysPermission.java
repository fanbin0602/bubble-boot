package me.fanbin.bubble.urpm.api.entity;

import lombok.Data;

/**
 * 菜单（权限）
 * @author fanbin
 * @date 2021/4/23
 */
@Data
public class SysPermission {

    private Integer id;
    private String code;
    private String name;
    private Integer parentId;
    private Integer sort;

    private String path;
    private String icon;
    private String type;

}
