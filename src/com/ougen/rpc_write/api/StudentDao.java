package com.ougen.rpc_write.api;

import com.ougen.rpc_write.module.Student;

/**
 * @author:ougen
 * @date:2018/10/2316:31
 */
public interface StudentDao {
    Student getStudent(int id);
}
