package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    private static String url = "https://api.github.com/search/repositories?q=stars:%3E1&sort=stars&order=desc&per_page=10";

    public static String getRepo(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("content-type", "application/json");
        HttpResponse result = null;
        try {
            result = httpClient.execute(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = null;
        try {
            json = EntityUtils.toString(result.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(json);
        return json;
    }
    public static void main(String[] args) {
        getRepo();
    }
}
