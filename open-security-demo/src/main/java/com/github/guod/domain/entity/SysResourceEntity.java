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
 * @date 日期:2018/4/25 时间:11:24
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
@Table(name = "sys_resource")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysResourceEntity extends BaseEntity {
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;
    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * ztree属性
     */
    private Boolean open;
    /**
     * 父菜单PID，一级菜单为0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PID")
    private SysResourceEntity permission;


    /**
     * 下级资源
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    private Set<SysResourceEntity> permissions;

    /**
     * 父菜单名称
     */
    private String parentName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "resources")
    private Set<SysRoleEntity> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public SysResourceEntity getPermission() {
        return permission;
    }

    public void setPermission(SysResourceEntity permission) {
        this.permission = permission;
    }

    public Set<SysResourceEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysResourceEntity> permissions) {
        this.permissions = permissions;
    }

    public Set<SysRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRoleEntity> roles) {
        this.roles = roles;
    }
}
