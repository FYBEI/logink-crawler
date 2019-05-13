package com.hongtu.crawler.mapper;

import com.hongtu.crawler.entity.UpWaybillData;
import com.hongtu.crawler.entity.VehicleLocateExpData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class VehicleLocateExpMapper{

    public int insertInBatch(List<VehicleLocateExpData> list){
        String resource = "sqlMapConfig.xml";
        int num = 0;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            num = sqlSession.insert("VechicleLocateExpInsertInBatch", list);
            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return num;
    }
}
