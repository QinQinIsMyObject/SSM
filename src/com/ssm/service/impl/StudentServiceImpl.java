package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.StudentMapper;
import com.ssm.entity.Student;
import com.ssm.service.StudentService;

/**
 * @author Shieh
 * @Date 2020-04-13 17:25:05
 * @Description
 *
 */
@Service // 标示业务层
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper stuMapper;

	// 增删改都需要进行事务的提交
	@Transactional
	public int addStu(Student stu) {
		return stuMapper.addStu(stu);
	}

	// 删除
	@Transactional
	public int deleteStu(Integer sno) {
		return stuMapper.deleteStu(sno);
	}

	// 修改
	@Transactional
	public int updateStu(Student stu) {
		return stuMapper.updateStu(stu);
	}

	// 查询单个
	@Override
	public Student selectBySno(Integer sno) {
		return stuMapper.selectBySno(sno);
	}

	// 查询所有
	@Override
	public List<Student> getList() {
		return stuMapper.getList();
	}

	// 根据名字模糊查询
	@Override
	public List<Student> getListBySname(String sname) {
		return stuMapper.getListBySname(sname);
	}

}
