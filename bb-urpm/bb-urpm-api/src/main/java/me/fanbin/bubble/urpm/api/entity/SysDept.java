package me.fanbin.bubble.urpm.api.entity;

import java.io.Serializable;

/**
 * 部门（父子关系）
 * @author fanbin
 * @date 2021/4/23
 */
public class SysDept implements Serializable {

    private Integer id;
    private Integer parentId;
    private String name;

}
