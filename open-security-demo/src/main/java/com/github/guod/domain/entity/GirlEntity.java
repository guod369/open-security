/**
 *
 */
package com.github.guod.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月19日 时间:下午6:35:35
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
@Table(name = "tb_girl")
public class GirlEntity extends BaseEntity implements Serializable {
    private String name;
    @JsonIgnore
    private Integer age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cupSize;
    private LocalDateTime birthday;
    /**
     * 映射在数据库是字符串类型,为首字符Y或者N
     */
    @Type(type = "yes_no")
    private Boolean marriage = false;
    /**
     * 映射在数据库中为0(false)或1(true)的Integer类型
     */
    @Type(type = "numeric_boolean")
    private Boolean adult = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Boolean getMarriage() {
        return marriage;
    }

    public void setMarriage(Boolean marriage) {
        this.marriage = marriage;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
}
