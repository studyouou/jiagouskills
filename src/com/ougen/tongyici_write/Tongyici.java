package com.ougen.tongyici_write;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author:ougen
 * @date:2018/8/2311:02
 */
public class Tongyici {

    public static void begin(String path) throws SQLException, IOException {
        String[] strings = getBiaoString(path);
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        String sql ;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> hasList = new ArrayList<String>();
        for (int i = 0 ; i<strings.length ; i++){
            sql = "select * from dba_synonyms where table_name = '"+strings[i]+"'";
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            if (!resultSet.next()){
                list.add(strings[i]);
            }else {
                hasList.add(strings[i]);
            }
        }
        close(connection,statement,resultSet);
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("------------");
        for (String s : hasList){
            System.out.println(s);
        }
    }

    private static String[] getBiaoString(String path) throws IOException {
        String[] strings = new String[1024];
        BufferedReader br = null;
        int i = 0;
        try {
            br = new BufferedReader(new FileReader(path));
            String biao = null;
            while (!"".equals(biao=br.readLine()) && biao != null){
                biao = biao.toUpperCase();
                strings[i] = biao ;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
        String[] newBiao = new String[i];
        for (int j=0;j < i;j++){
            newBiao[j] = strings[j];
        }
        return newBiao;
    }

    private static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//找到oracle驱动器所在的类
            String url="jdbc:oracle:thin:@10.22.8.229:1521:cscb"; //URL地址
            String username="AI12580";
            String password="ai12580";
            conn= DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    private static void close(Connection connection , Statement  statement , ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
