package com.ougen.tongyici_write;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author:ougen
 * @date:2018/8/2313:54
 */
public class TongyiciMain {
    public static void main(String[] args) throws IOException, SQLException {
        Tongyici.begin("e:/chuchong_exam.txt");
    }
}
