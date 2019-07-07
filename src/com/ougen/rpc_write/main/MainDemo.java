package com.ougen.rpc_write.main;

import com.ougen.rpc_write.api.StudentDao;
import com.ougen.rpc_write.module.Student;

/**
 * @author:ougen
 * @date:2018/10/2316:36
 */
public class MainDemo {
    public static void main(String[] args) throws Exception {
        StudentDao studentDao = (StudentDao) RPC.getService(StudentDao.class);
        Student student = studentDao.getStudent(100);
        System.out.println(student);
    }
}
