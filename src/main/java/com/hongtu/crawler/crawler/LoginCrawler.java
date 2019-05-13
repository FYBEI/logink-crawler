package com.hongtu.crawler.crawler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class LoginCrawler {
    CloseableHttpClient httpClient;

    BasicCookieStore cookieStore = new BasicCookieStore();

    public BasicCookieStore login(){
        //设置cookie存储
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();

        //登录所必须访问的三个url
        String[] url = {"https://jc.logink.org/nocc/business/index.html",
                "https://jc.logink.org/nocc/public/isLogin.htm?randomNum=0.6222284679412853",
                "https://jc.logink.org/nocc/public/wu_ssoLogin.htm?randomNum=0.42364935675724547&account=14203&secretcode=f99ea9bc702a08e74a79e6ca96f26a80&loginUserType=01"};

        //请求登录的cookie
        HttpGet httpGet1 = new HttpGet(url[0]);

        try{
            HttpResponse httpResponse1 = httpClient.execute(httpGet1);

            if (httpResponse1.getStatusLine().getStatusCode() == 200){

                HttpGet httpGet2 = new HttpGet(url[1]);

                HttpResponse httpResponse2 = httpClient.execute(httpGet2);
                if (httpResponse2.getStatusLine().getStatusCode() == 200){

                    //将之前请求到的cookie建立新的httpClient，发送登录请求
                    HttpClient newhttpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

                    HttpGet httpGet3 = new HttpGet(url[2]);

                    HttpResponse httpResponse3 = newhttpClient.execute(httpGet3);

                    if (httpResponse3.getStatusLine().getStatusCode() == 200){
                        return this.cookieStore;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return this.cookieStore;
    }



}
