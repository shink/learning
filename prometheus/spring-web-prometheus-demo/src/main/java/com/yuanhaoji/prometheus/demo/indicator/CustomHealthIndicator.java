package com.yuanhaoji.prometheus.demo.indicator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author: shenke
 * @project: spring-web-prometheus-demo
 * @date: 2021/11/13
 * @desp:
 */

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 使用 builder 来创建健康状态信息
        // 如果 throw 了一个 exception，那么 status 就会被置为 DOWN，异常信息会被记录下来
        builder.up()
                .withDetail("app", "Everything is OK!")
                .withDetail("error", "There is something wrong!");
    }

}
