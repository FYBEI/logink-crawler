package com.hongtu.crawler.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongtu.crawler.entity.UpWaybillData;
import com.hongtu.crawler.mapper.UpWaybillDataMapper;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class UpDataCrawler extends BaseCrawler implements Runnable{

    @Override
    public List<UpWaybillData> getObject() {

        JSONObject json = JSON.parseObject(data);

        JSONObject data = (JSONObject) json.get("data");
        List list = (List) data.get("list");

        List<UpWaybillData> upWaybillDataList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            UpWaybillData upWaybillData;
            JSONObject tmp = (JSONObject) list.get(i);
            String str = JSONObject.toJSONString(tmp);

            upWaybillData = JSONObject.parseObject(str, UpWaybillData.class);
            upWaybillDataList.add(upWaybillData);

        }

        return upWaybillDataList;
    }

    /**
     * 线程执行函数，先获得服务器的返回数据，接着解析数据得到list，在通过mapper插入list
     */
    @Override
    public void run() {
        for(int i = 0; i <= pageNum; i++){
            String current_page = i + "";
            String start = "2019-05-01";
            String end = "2019-05-08";

            List<NameValuePair> params = setParam(false, current_page, start, end);

            getData(params);
            List<UpWaybillData> list = getObject();

//          for (UpWaybillData obj : list){
//                System.out.println(obj);
//          }

            UpWaybillDataMapper dao = new UpWaybillDataMapper();
            dao.insertInBatch(list);
        }

    }
}
