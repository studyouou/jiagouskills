package com.ougen.bloom_write;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:ougen
 * @date:2018/8/2014:53
 */
public class BloomMain {
    public static void main(String[] args) {
      //  DateUtil.changeName();
        long l = 12l;
        int h = (int)(l ^ (l>>>32));
        System.out.println(h+(0^0));
    }
}
class DateUtil {
    public DateUtil() {
    }

    public static void changeName() {
        File file = new File(getYestordayFileName());
        file.renameTo(new File(getTodayFileName()));
    }

    public static String getTodayFileName() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(date);
        String[] ymd = s.split("-");
        String path = "D:\\搜狗高速下载\\工作日报_欧根_" + ymd[0] + ymd[1] + ymd[2] + ".xlsx";
        return path;
    }

    public static String getYestordayFileName() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(date);
        String[] ymd = s.split("-");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        int nowWeek = getWeek(date);
        int[] t;
        if (nowWeek == 1) {
            t = reduceW(year, month, day);
            year = t[0];
            month = t[1];
            day = t[2];
        } else {
            t = reduce(year, month, day);
            year = t[0];
            month = t[1];
            day = t[2];
        }

        if (ymd[1].equals("1") && ymd[2].equals("1")) {
            ymd[0] = String.valueOf(year - 1);
        }

        String monthNew = monthNew(month);
        String path = "D:\\搜狗高速下载\\工作日报_欧根_" + String.valueOf(year) + monthNew + day + ".xlsx";
        return path;
    }

    private static String monthNew(int month) {
        return month < 10 ? "0" + String.valueOf(month) : String.valueOf(month);
    }

    private static int[] reduce(int year, int month, int day) {
        if (day == 1) {
            if (month < 7) {
                if (month == 2) {
                    if (year % 4 == 0) {
                        day = 29;
                    } else {
                        day = 28;
                    }
                } else if (month != 1) {
                    if (month % 2 == 0) {
                        day = 30;
                    } else {
                        day = 31;
                    }
                } else {
                    day = 31;
                }
            } else if (month == 8) {
                day = 31;
            } else if (month % 2 == 0) {
                day = 30;
            } else {
                day = 31;
            }

            if (month == 1) {
                month = 12;
            } else {
                --month;
            }
        } else {
            --day;
        }

        return new int[]{year, month, day};
    }

    public static int[] reduceW(int year, int month, int day) {
        if (day < 4) {
            if (month < 7) {
                if (month == 2) {
                    if (year % 4 == 0) {
                        day = 29 + day - 3;
                    } else {
                        day = 28 + day - 3;
                    }
                } else if (month != 1) {
                    if (month % 2 == 0) {
                        day = 30 + day - 3;
                    } else {
                        day = 31 + day - 3;
                    }
                } else {
                    day = 31 + day - 3;
                }
            } else if (month == 8) {
                day = 31 + day - 3;
            } else if (month % 2 == 0) {
                day = 30 + day - 3;
            } else {
                day = 31 + day - 3;
            }

            if (month == 1) {
                month = 12;
            } else {
                --month;
            }
        } else {
            day -= 3;
        }

        return new int[]{year, month, day};
    }

    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int nowWeek = calendar.get(7) - 1;
        return nowWeek;
    }
}
