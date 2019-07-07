package com.ougen.mybatis_read;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author:ougen
 * @date:2018/9/2912:51
 */
public class MybatisRead {
    public static void main(String[] args) throws IOException {
        Reader resources = Resources.getResourceAsReader("");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resources);
    }
}
