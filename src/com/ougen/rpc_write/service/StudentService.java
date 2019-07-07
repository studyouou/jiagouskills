package com.ougen.rpc_write.service;

import com.ougen.rpc_write.api.StudentDao;
import com.ougen.rpc_write.module.Student;

/**
 * @author:ougen
 * @date:2018/10/2316:33
 */
public class StudentService implements StudentDao {

    @Override
    public Student getStudent(int id) {
        Student student = new Student();
        student.setId(id);
        student.setAge(22);
        student.setName("欧根");
        student.setShcool("成都理工大学");
        return student;
    }
}
