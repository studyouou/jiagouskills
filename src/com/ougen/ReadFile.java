package com.ougen;

import java.io.*;
import java.util.BitSet;

/**
 * @author:ougen
 * @date:2018/8/2015:46
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
//        readFile.startRead("E:\\公司练习\\superAgent\\config\\com\\asiainfo\\csc\\main\\bo\\search\\BOSearchCallOut");
        readFile.chachong("E:\\exam_data.txt");
    }

    public void chachong(String path) throws IOException {
        BitSet bitSet = new BitSet();
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter("e:/chuchong_exam.txt"));
        String li = null ;
        while (!"".equals(li = reader.readLine()) && li!=null){
            String s = li.toLowerCase().trim();
            toWenJian(s,s.hashCode(),bitSet,writer);
        }
        writer.close();
        reader.close();

    }

    private void toWenJian(String s, int hash, BitSet bitSet, BufferedWriter writer) throws IOException {
        if (hash<0){
            hash = Math.abs(hash);
        }
        if (!bitSet.get(hash)){
            bitSet.set(hash);
            writer.write(s);
            writer.write("\r\n");
            writer.flush();
        }else {
            System.out.println(s+"重复了");
        }
    }


    private void startRead(String filePath) throws IOException {
        File file = new File(filePath);
        File file1 = new File("e:/database1.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        startRead(file, bufferedWriter);
        bufferedWriter.close();
    }

    private void startRead(File file, BufferedWriter write) throws IOException {
        File[] files = file.listFiles();
        if (files == null) {
            if (file.getName().endsWith(".bo")) {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(reader);
                int len = 0;
                String str = null;
                while (!"".equals((str = br.readLine())) && str != null) {
                    if (str.contains("T_")) {
                        if (str.contains("{")) {
                            String div = str.substring(str.indexOf("{"));
                            String newS = div.substring(str.indexOf("}"));
                            write.write(newS);
                        } else {
                            String div = str.substring(str.indexOf(">") + 1);
                            String newS = div.substring(0, div.indexOf("<"));
                            write.write(newS);
                            write.flush();
                        }
                    }
                }
                reader.close();
                br.close();
                return;
            }
        }
        for (File file1 : files) {
            if (file1.isDirectory()) {
                startRead(file1, write);
            } else {
                if (file1.getName().endsWith(".bo")) {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(file1));
                    BufferedReader br = new BufferedReader(reader);
                    int len = 0;
                    String str = null;
                    while (!"".equals(str = br.readLine()) && str != null) {
                       //..............
                    }
                    reader.close();
                    br.close();
                }
            }
        }


    }
}
