package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.Student;
import com.ssm.service.StudentService;

/**
 * @author Shieh
 * @Date 2020-04-13 17:28:01
 * @Description
 *
 */
@Controller
public class StudentController {

	@Autowired
	private StudentService stuService;

	@RequestMapping("/stulist.do")
	public ModelAndView getList() {
		// 调用业务层方法，返回一个集合
		List<Student> slist = stuService.getList();
		if (slist != null) {
			// 第一个值对比逻辑视图名，第二个值代表要传到页面的key，第三是要传到页面key对应的值
			return new ModelAndView("index", "stulist", slist);
		}
		return null;
	}
}
