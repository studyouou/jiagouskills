package com.ougen.jiami_write;

import java.util.Random;

/**
 * @author:ougen
 * @date:2018/9/815:52
 */
public class Salt {
    public static String getSalt(){
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i<20;i++) {
            switch (random.nextInt(20)) {
                case 1:
                    stringBuffer.append(1);
                    break;
                case 2:
                    stringBuffer.append(2);
                    break;
                case 3:
                    stringBuffer.append(3);
                    break;
                case 4:
                    stringBuffer.append(4);
                    break;
                case 5:
                    stringBuffer.append(5);
                    break;
                case 6:
                    stringBuffer.append(6);
                    break;
                case 7:
                    stringBuffer.append(7);
                    break;
                case 8:
                    stringBuffer.append(8);
                    break;
                case 9:
                    stringBuffer.append(9);
                    break;
                case 0:
                    stringBuffer.append(0);
                    break;
                case 10:
                    stringBuffer.append("!");
                    break;
                case 11:
                    stringBuffer.append("@");
                    break;
                case 12:
                    stringBuffer.append("#");
                    break;
                case 13:
                    stringBuffer.append("$");
                    break;
                case 14:
                    stringBuffer.append("~");
                    break;
                case 15:
                    stringBuffer.append("%");
                    break;
                case 16:
                    stringBuffer.append("&");
                    break;
                case 17:
                    stringBuffer.append("(");
                    break;
                case 18:
                    stringBuffer.append("+");
                    break;
                case 19:
                    stringBuffer.append("\\");
                    break;
            }
        }
        return stringBuffer.toString();
    }
}
