package org.wys.demo.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author wys
 * @date 2021/11/10
 */
public class ElasticsearchDemo {
    public static void main(String[] args) {
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200));
        RestHighLevelClient client = new RestHighLevelClient(restClientBuilder);
        searchIndex(client);
    }
    public static void createIndex(RestHighLevelClient client) {
        try {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("zzzzz");
            CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            System.out.println(JSONObject.toJSON(createIndexResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchIndex(RestHighLevelClient client) {
        IndexRequest indexRequest = new IndexRequest("zzzzz");
        User user = new User();
        user.setId(1L);
        user.setName("测试");
        String userJson = JSONObject.toJSONString(JSON.toJSON(user));
        indexRequest.source(userJson, XContentType.JSON);
        try {
            IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
            if (response != null) {
                ReplicationResponse.ShardInfo shardInfo = response.getShardInfo();
            }
            System.out.println(JSONObject.toJSON(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Data
    static class User implements Serializable {

        private static final long serialVersionUID = 3923003386726288852L;
        private String name;
        private Long id;
    }
}
