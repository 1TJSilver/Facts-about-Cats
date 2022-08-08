import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        uri("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
    }
    public static void uri (String uri){
        try {
            ObjectMapper map = new ObjectMapper();
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build())
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            List<Cat> cats = map.readValue(
                    response.getEntity().getContent(),
                    new TypeReference<>() {
                    }
            );
            List<Cat> cats1 = cats.stream()
                    .filter(cat -> cat.getUpVotes() != null && cat.getUpVotes() != 0)
                    .toList();
            for (Cat cat : cats1) {
                System.out.println(cat.toString());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
