package com.cloud.shop;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
@SpringBootTest
class ShopApplicationTests {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void testClient() throws IOException {
        //1 构建请求
        GetRequest getRequest = new GetRequest("megacorp", "1");
        //2 执行
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        //3 获取请求结果
        System.out.println(getResponse.getId());
        System.out.println(getResponse.getVersion());
        System.out.println(getResponse.getSourceAsString());
    }


}
