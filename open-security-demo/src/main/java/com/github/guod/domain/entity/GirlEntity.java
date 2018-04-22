/**
 *
 */
package com.github.guod.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Table;
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
public class GirlEntity extends BaseEntity {
    private String name;
    @JsonIgnore
    private Integer age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cupSize;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

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
}
