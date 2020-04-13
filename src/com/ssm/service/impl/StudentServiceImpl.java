package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Student> getList() {
		return stuMapper.getList();
	}

}
