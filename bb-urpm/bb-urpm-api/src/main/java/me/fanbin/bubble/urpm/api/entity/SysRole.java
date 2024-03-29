package me.fanbin.bubble.urpm.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 * @author fanbin
 * @date 2021/4/23
 */
@Data
public class SysRole implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String description;

}
