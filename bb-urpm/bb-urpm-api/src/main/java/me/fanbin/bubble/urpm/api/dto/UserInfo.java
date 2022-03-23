package me.fanbin.bubble.urpm.api.dto;

import lombok.Data;
import me.fanbin.bubble.urpm.api.entity.SysRole;
import me.fanbin.bubble.urpm.api.entity.SysUser;

import java.io.Serializable;
import java.util.List;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@Data
public class UserInfo implements Serializable {

    private SysUser sysUser;

    private String[] permissions;

    private Integer[] roles;

    private List<SysRole> roleList;

}
