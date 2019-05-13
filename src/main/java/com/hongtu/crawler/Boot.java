package com.hongtu.crawler;

import com.hongtu.crawler.crawler.LoginCrawler;
import com.hongtu.crawler.crawler.UpDataCrawler;
import com.hongtu.crawler.crawler.VehicleLocateExpDataCrawler;
import com.hongtu.crawler.entity.UpWaybillData;
import com.hongtu.crawler.entity.VehicleLocateExpData;
import com.hongtu.crawler.mapper.UpWaybillDataMapper;
import com.hongtu.crawler.mapper.VehicleLocateExpMapper;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Boot {

    public static void main(String[] args){
        LoginCrawler loginCrawler = new LoginCrawler();
        BasicCookieStore cookieStore = loginCrawler.login();

        //准备爬虫所需的参数
        String veh_url = "https://jc.logink.org/nocc/bgmanage/BookingLocationAction_searchListNew.htm";
        String up_url = "https://jc.logink.org/nocc/bgmanage/except_searchList.htm";

        int veh_pageNum = 1;
        int up_pageNum = 1;

        //创建爬虫
        VehicleLocateExpDataCrawler vehicleLocateExpDataCrawler = new VehicleLocateExpDataCrawler();
        vehicleLocateExpDataCrawler.setCookieStore(cookieStore);
        vehicleLocateExpDataCrawler.setUrl(veh_url);
        vehicleLocateExpDataCrawler.setPageNum(veh_pageNum);

        UpDataCrawler upDataCrawler = new UpDataCrawler();
        upDataCrawler.setCookieStore(cookieStore);
        upDataCrawler.setUrl(up_url);
        upDataCrawler.setPageNum(up_pageNum);

        //创建线程
        Thread veh_thread = new Thread(vehicleLocateExpDataCrawler);
        veh_thread.setName("vehThread");
        Thread up_thread = new Thread(upDataCrawler);
        up_thread.setName("upThread");

        //开启线程
        veh_thread.start();
        up_thread.start();

        //主线程要等待爬虫线程结束后再结束
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
