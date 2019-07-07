package com.ougen.classjiazai_write;

import java.io.*;

/**
 * @author:ougen
 * @date:2019/1/513:03
 */
public class LeiJiaZai extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream i = getPath(name);
        try {
            byte[] data = getBytes(i);
            if (data == null){
                throw new NoClassDefFoundError("没找到该类");
            }
            return defineClass(name,data,0,data.length);
        } catch (IOException e) {

        }
        return super.findClass(name);
    }

    private byte[] getBytes(InputStream i) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1 ;
        byte[] buf = new byte[1024];
        while ((len = i.read(buf))!=-1){
            baos.write(buf,0,len);
        }
        return baos.toByteArray();
    }

    private InputStream getPath(String name) {
        try {
            return new FileInputStream("E:\\workspace\\WenDang\\bin\\DeleteAnswer.class");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
