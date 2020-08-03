import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

// refs:[Java爬虫入门简介（一） —— HttpClient请求及其使用方法](https://blog.csdn.net/df19900725/article/details/76221690)
public class FirstTest {
    public static void main(String[] args) {
        System.out.println("hello");

        // 建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet("http://www.datalearner.com/blog");

        // 获取网址的返回结果
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取返回结果中的实体
        HttpEntity entity = response.getEntity();

        // 将返回的实体输出
        try {
            System.out.println(EntityUtils.toString(entity));
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}