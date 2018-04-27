package com.github.guod.templatecode;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/26 时间:7:45
 * @JDK 1.8
 * @Description 功能模块：抽象模板角色类
 */
public abstract class Account {
    public final double calculateInterest() {
        //利息百分比
        double interestRate = doCalculateInterestRate();
        //账号类型
        String accountType = doCalculateAccountType();
        //账号内存款
        double amount = calculateAmount(accountType);
        //返回利息数额
        return amount * interestRate;
    }

    /**
     * 基本方法，留给子类实现
     *
     * @return
     */
    protected abstract String doCalculateAccountType();

    /**
     * 基本方法，留给子类实现
     *
     * @return
     */
    protected abstract double doCalculateInterestRate();

    /**
     * 基本方法，已经实现
     *
     * @param accountType
     * @return
     */
    private double calculateAmount(String accountType) {
        //TODO 省略相关的业务逻辑
        System.out.println(accountType);
        return 1234.00;
    }

}
