package com.yuanhaoji.prometheus.demo.controller;

import com.yuanhaoji.prometheus.demo.monitor.PrometheusCustomMonitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author: shenke
 * @project: spring-web-prometheus-demo
 * @date: 2021/11/13
 * @desp:
 */

@RestController
public class TestController {

    @Resource
    private PrometheusCustomMonitor monitor;

    @RequestMapping("/order")
    public String order() throws Exception {
        // 统计下单次数
        monitor.getOrderCount().increment();
        Random random = new Random();
        int amount = random.nextInt(100);
        // 统计金额
        monitor.getAmountSum().record(amount);
        return "下单成功, 金额: " + amount;
    }
}
