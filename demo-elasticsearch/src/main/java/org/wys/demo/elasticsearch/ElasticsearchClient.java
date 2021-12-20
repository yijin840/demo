package org.wys.demo.elasticsearch;

import org.apache.http.HttpHost;

/**
 * @author wys
 * @date 2021/11/10
 */
public class ElasticsearchClient {

    private String[] hostsAndPorts;

    public ElasticsearchClient(String[] hostsAndPorts) {
        this.hostsAndPorts = hostsAndPorts;
    }

}