package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ssm.entity.Student;

/**
 * @author Shieh
 * @Date 2020-04-13 17:19:36
 * @Description
 *
 */
public interface StudentMapper {

	@Insert("insert into student(sname,sex,age,gid,phone,address)value(#{sname},#{sex},#{age},#{gid},#{phone},#{address})")
	int addStu(Student stu);

	@Delete("delete from student where sno=#{sno}")
	int deleteStu(Integer sno);

	/**
	 * @param stu
	 * @return
	 */
	int updateStu(Student stu);

	@Select("select * from student")
	List<Student> getList();

	// 根据学生编号查询单个学生---查看学生详情
	@Select("select * from student where sno=#{sno}")
	Student selectBySno(Integer sno);

}
