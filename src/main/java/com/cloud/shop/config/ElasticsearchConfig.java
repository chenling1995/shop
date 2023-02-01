package com.cloud.shop.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${chengbkj.elasticsearch.hosts}")
    public String hostList;

    @Bean
    public RestHighLevelClient restHighLevelClient(){

        String[] hostArr = hostList.split(",");
        //1、创建一个httpHosts数组
        HttpHost[] httpHosts = new HttpHost[hostArr.length];

        for (int i = 0; i < hostArr.length; i++) {
            String item = hostArr[i];
            httpHosts[i] = new HttpHost(item.split(":")[0],Integer.parseInt(item.split(":")[1]),"http");
        }

        return new RestHighLevelClient(RestClient.builder(httpHosts));
    }


}
