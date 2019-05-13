package com.hongtu.crawler.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongtu.crawler.entity.VehicleLocateExpData;
import com.hongtu.crawler.mapper.VehicleLocateExpMapper;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class VehicleLocateExpDataCrawler extends BaseCrawler implements Runnable {

    @Override
    public List<VehicleLocateExpData> getObject(){

        //解析json型数据，获取返回的list
        JSONObject json = JSON.parseObject(data);

        JSONObject data = (JSONObject) json.get("data");
        List list = (List) data.get("list");

        //获取的数据添加进vehicleLocateExpDataList
        List<VehicleLocateExpData> vehicleLocateExpDataList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            VehicleLocateExpData vehicleLocateExpData;
            JSONObject tmp = (JSONObject) list.get(i);
            String str = JSONObject.toJSONString(tmp);

            vehicleLocateExpData = JSONObject.parseObject(str, VehicleLocateExpData.class);

            vehicleLocateExpDataList.add(vehicleLocateExpData);
        }

        return vehicleLocateExpDataList;

    }

    /**
     * 线程执行函数，先获得服务器的返回数据，接着解析数据得到list，在通过mapper插入list
     */
    @Override
    public void run() {
        for(int i = 0; i <= pageNum; i++) {
            String current_page = i + "";
            String start = "2019-05-01";
            String end = "2019-05-08";

            List<NameValuePair> params = setParam(false, current_page, start, end);

            getData(params);
            List<VehicleLocateExpData> list = getObject();

//          for (VehicleLocateExpData obj : list){
//                System.out.println(obj);
//          }

            VehicleLocateExpMapper dao = new VehicleLocateExpMapper();
            dao.insertInBatch(list);
        }

    }
}
