/**
 *
 */
package com.github.guod.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

/**
 * project - 权限管理框架
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月19日 时间:下午6:35:49
 * @JDK 1.8
 * @Description 功能模块：
 */
public class GirlVO {
    /**
     * 简单视图
     */
    public interface GirlSimpleValidate {
    }

    /**
     * 详细视图
     */
    public interface GirlDetailValidate extends GirlSimpleValidate {
    }

    @ApiModelProperty(value = "用户ID", hidden = false)
    private String id;
    @NotNull(groups = GirlDetailValidate.class)
    @ApiModelProperty(value = "姓名", hidden = false)
    private String name;
    @NotNull
    @ApiModelProperty(value = "年龄", hidden = false)
    private Integer age;
    @ApiModelProperty(value = "大小", hidden = false)
    private String cupSize;
    @ApiModelProperty(value = "出生年月")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    @ApiModelProperty(required = true, example = "2016-01-01")
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDate startTime;

    @ApiModelProperty(value = "失效日期必填", notes = "yyyy-MM-dd，缺省日期为2999-12-31", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "失效日期必填")
    private LocalDate endTime;

    public Integer getAge() {
        return age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
}
