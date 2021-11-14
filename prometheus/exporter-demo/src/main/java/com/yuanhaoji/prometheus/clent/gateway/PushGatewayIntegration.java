package com.yuanhaoji.prometheus.clent.gateway;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.PushGateway;

import java.io.IOException;

/**
 * @author: shenke
 * @project: exporter-demo
 * @date: 2021/11/14
 * @desp:
 */
public class PushGatewayIntegration {

    /**
     * 从所有注册到 defaultRegistry 的 Collector 实例中获取样本数据并直接推送到外部部署的 PushGateway 服务中
     */
    public void push() throws IOException {
        CollectorRegistry registry = CollectorRegistry.defaultRegistry;
        PushGateway pg = new PushGateway("127.0.0.1:9091");
        pg.pushAdd(registry, "my_batch_job");
    }

}
