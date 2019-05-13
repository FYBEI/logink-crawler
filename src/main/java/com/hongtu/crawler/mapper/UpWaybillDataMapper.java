package com.hongtu.crawler.mapper;

import com.hongtu.crawler.entity.UpWaybillData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UpWaybillDataMapper {

    public int insertInBatch(List<UpWaybillData> list){
        String resource = "sqlMapConfig.xml";
        int num = 0;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            num = sqlSession.insert("UpWaybillDataInsertInBatch", list);
            sqlSession.commit();

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return num;
    }
}
