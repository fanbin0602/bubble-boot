package me.fanbin.bubble.urpm.api.service;

import me.fanbin.bubble.urpm.api.model.SysDept;

/**
 * 部门服务
 * @author fanbin
 * @date 2021/4/23
 */
public interface DeptService {

    /**
     * 添加
     * @param dept 部门信息
     */
    void add(SysDept dept);

    /**
     * 修改
     * @param dept 部门信息
     */
    void update(SysDept dept);

    /**
     * 删除
     * @param id 部门id
     */
    void deleteById(Integer id);

    /**
     * 查找
     * @param id 部门id
     * @return 部门信息
     */
    SysDept getById(Integer id);



}
