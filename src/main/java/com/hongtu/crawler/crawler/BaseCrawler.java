package com.hongtu.crawler.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCrawler {
    /**
     *继承loginCrawler的cookieStore
     */
    protected BasicCookieStore cookieStore;

    /**
     * 爬取的数据
     */
    protected String data;

    /**
     * 所需爬取页面的url
     */
    protected String url;

    /**
     * 请求的总页数
     */
    protected int pageNum = 1;

    /**
     * 根据需要爬取的不同表单，提供所需的url和parameters
     */
    public void getData(List<NameValuePair> params){
        HttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost(url);

        try{
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity httpEntity = httpResponse.getEntity();
                String tmp = EntityUtils.toString(httpEntity);//取出应答字符串
                this.data = tmp;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected List<NameValuePair> setParam(boolean kind, String num, String start, String end){
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "list"));
        params.add(new BasicNameValuePair("scope", "all"));
        params.add(new BasicNameValuePair("reqid", "0.8758907232047446"));
        params.add(new BasicNameValuePair("pageSize", "10"));
        params.add(new BasicNameValuePair("currentPage", num));

        if (kind){
            params.add(new BasicNameValuePair("entity.create_s", start));
            params.add(new BasicNameValuePair("entity.create_e", end));
            params.add(new BasicNameValuePair("pageId", "18427"));
        }else {
            params.add(new BasicNameValuePair("entity.exceptState", "99"));
            params.add(new BasicNameValuePair("entity.createDate_start", start));
            params.add(new BasicNameValuePair("entity.createDate_end", end));
            params.add(new BasicNameValuePair("pageId", "803"));
        }

        return params;
    }

    public void setUrl(String url){this.url = url; }

    public void setCookieStore(BasicCookieStore cookieStore){
        this.cookieStore = cookieStore;
    }

    public void setPageNum(int pageNum){this.pageNum = pageNum;}

    /**
     * 从爬取的数据（json类型）中截取所需要的属性，生成对应的实体对象
     * @throws Exception
     * @return
     */
    protected abstract <T> List<T> getObject() throws Exception;
}
