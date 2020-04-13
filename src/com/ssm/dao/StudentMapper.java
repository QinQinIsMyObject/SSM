package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ssm.entity.Student;

/**
 * @author Shieh
 * @Date 2020-04-13 17:19:36
 * @Description
 *
 */
public interface StudentMapper {

	@Select("select * from student")
	List<Student> getList();

}
