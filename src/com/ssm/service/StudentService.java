package com.ssm.service;

import java.util.List;

import com.ssm.entity.Student;

/**
 * @author Shieh
 * @Date 2020-04-13 17:22:13
 * @Description 业务层
 *
 */
public interface StudentService {

	int addStu(Student stu);

	int deleteStu(Integer sno);

	int updateStu(Student stu);

	List<Student> getList();

	Student selectBySno(Integer sno);
}
