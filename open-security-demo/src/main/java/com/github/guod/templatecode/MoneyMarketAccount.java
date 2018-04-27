package com.github.guod.templatecode;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/26 时间:7:53
 * @JDK 1.8
 * @Description 功能模块：具体模板角色类
 */
public class MoneyMarketAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }
}
