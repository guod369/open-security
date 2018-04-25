package com.github.guod.domain.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/25 时间:11:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
@Table(name = "sys_role")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<SysUserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_resource",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)})
    private Set<SysResourceEntity> resources;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SysUserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUserEntity> users) {
        this.users = users;
    }

    public Set<SysResourceEntity> getResources() {
        return resources;
    }

    public void setResources(Set<SysResourceEntity> resources) {
        this.resources = resources;
    }
}
