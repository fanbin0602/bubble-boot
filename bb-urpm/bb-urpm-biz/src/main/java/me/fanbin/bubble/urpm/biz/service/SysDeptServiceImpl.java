package me.fanbin.bubble.urpm.biz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.fanbin.bubble.urpm.api.entity.SysDept;
import me.fanbin.bubble.urpm.api.service.SysDeptService;
import me.fanbin.bubble.urpm.biz.mapper.SysDeptMapper;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author fanbin
 * @date 2021/4/26
 */
@DubboService
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
}
