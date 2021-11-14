package com.yuanhaoji.prometheus.clent.metric;

import io.prometheus.client.Gauge;

/**
 * @author: shenke
 * @project: exporter-demo
 * @date: 2021/11/14
 * @desp:
 */
public class CustomGauge {

    static final Gauge myGauge = Gauge.build().name("inprogress_requests").help("Inprogress requests.").register();

    void processRequest() {
        myGauge.inc();
        // Your code here.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myGauge.dec();
    }

}
