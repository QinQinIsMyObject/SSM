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

	@Transactional
	public int addStu(Student stu) {
		return stuMapper.addStu(stu);
	}

	@Transactional // 增删改都需要进行事务的提交
	public int deleteStu(Integer sno) {
		return stuMapper.deleteStu(sno);
	}

	@Transactional
	public int updateStu(Student stu) {
		return stuMapper.updateStu(stu);
	}

	@Override
	public List<Student> getList() {
		return stuMapper.getList();
	}

	@Override
	public Student selectBySno(Integer sno) {
		return stuMapper.selectBySno(sno);
	}

}
