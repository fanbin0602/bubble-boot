package me.fanbin.bubble.urpm.api.entity;

import lombok.Data;

/**
 * 菜单（权限）
 * @author fanbin
 * @date 2021/4/23
 */
@Data
public class SysMenu {

    private Integer id;
    private String name;
    private String permission;
    private String path;
    private Integer parentId;
    private String icon;
    private Integer sort;
    private String type;

}
