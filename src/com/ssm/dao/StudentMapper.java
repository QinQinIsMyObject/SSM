package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssm.entity.Student;

/**
 * @author Shieh
 * @Date 2020-04-13 17:19:36
 * @Description
 *
 */
public interface StudentMapper {

	// 增加功能
//	@Insert("insert into student(sname,sex,age,gid,phone,address)value(#{sname},#{sex},#{age},#{gid},#{phone},#{address})")
	int addStu(Student stu);

	// 删除
	@Delete("delete from student where sno=#{sno}")
	int deleteStu(Integer sno);

	// 修改
	int updateStu(Student stu);

	// 根据学生编号查询单个学生---查看学生详情
	@Select("select * from student where sno=#{sno}")
	Student selectBySno(Integer sno);

	// 查询所有
	@Select("select * from student")
	List<Student> getList();

	// 根据名字查询
	List<Student> getListBySname(@Param("sname") String sname);
}
