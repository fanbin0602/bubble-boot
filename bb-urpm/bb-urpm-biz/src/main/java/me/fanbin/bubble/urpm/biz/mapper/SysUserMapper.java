package me.fanbin.bubble.urpm.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import me.fanbin.bubble.urpm.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fanbin
 * @date 2022/3/11
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页查询 SysUser 对象
     * @param page 分页信息
     * @param conditions 查询条件
     * @return 查询结果
     * @param <E> 分页信息类型
     */
    <E extends IPage<SysUser>> E selectPage(E page, SysUser conditions);

}
