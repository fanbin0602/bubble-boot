package me.fanbin.bubble.urpm.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * @author fanbin
 * @date 2021/4/23
 */
@Data
public class SysUser implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
}
