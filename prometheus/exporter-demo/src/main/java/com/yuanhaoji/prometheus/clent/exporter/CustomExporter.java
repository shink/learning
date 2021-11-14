package com.yuanhaoji.prometheus.clent.exporter;

import com.yuanhaoji.prometheus.clent.collector.CustomCollector;
import com.yuanhaoji.prometheus.clent.collector.CustomCollector2;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

import java.io.IOException;

/**
 * @author: shenke
 * @project: exporter-demo
 * @date: 2021/11/14
 * @desp:
 */
public class CustomExporter {

    public static void main(String[] args) throws IOException {
        DefaultExports.initialize();

        new CustomCollector().register();
        new CustomCollector2().register();

        HTTPServer server = new HTTPServer(1234);
    }

}
