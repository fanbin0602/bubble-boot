/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.fanbin.bubble.urpm.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.fanbin.bubble.urpm.api.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysPermission> {
}
