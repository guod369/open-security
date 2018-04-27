package com.github.guod.templatecode;

/**
 * project - ETC发票系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/4/26 时间:7:55
 * @JDK 1.8
 * @Description 功能模块：测试类
 */
public class TemplateCodeMain {
    public static void main(String[] args) {
        Account account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());

    }
}
