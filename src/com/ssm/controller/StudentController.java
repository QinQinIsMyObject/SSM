package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	// 去增加的页面
	@RequestMapping("/toAdd.do")
	public String toAdd() {
		return "addStu";
	}

	// 增加学生
	@RequestMapping("/doAddStu.do")
	public ModelAndView addStu(Student stu) {
		int num = stuService.addStu(stu);
		if (num > 0) {
			// 需要带数据msg-转发到去首页Controller；不需要带数据可以使用重定向
			return new ModelAndView("forward:stulist.do", "msg", "增加成功!");
		}
		return null;
	}

	// 根据学生编号删除单个学生
	@RequestMapping("/deleteStu.do")
	public ModelAndView deleteStu(Integer sno) {
		// 删除返回的是影响的行数
		int num = stuService.deleteStu(sno);
		if (num > 0) {
			// forward:stulist.do表示转发，不是逻辑视图名；如果改成redirect重定向，消息带不过去
//			return new ModelAndView("redirect:stulist.do", "msg", "删除成功！");
			return new ModelAndView("forward:stulist.do", "msg", "删除成功！");
		}
		return null;
	}

	// 去修改页面并查询单个学生信息-进行展示
	@RequestMapping("/toUpdatePage.do")
	public ModelAndView toUpdateStuPage(Integer sno) {
		Student stu = stuService.selectBySno(sno);
		if (stu != null) {
			// 第一个值对比逻辑视图名，第二个值代表要传到页面的key，第三是要传到页面key对应的值
			// 去修改页面
			return new ModelAndView("updateStu", "stu", stu);
		}
		return null;
	}

	// 真正的修改学生信息
	@RequestMapping("/doUpdate.do")
	public ModelAndView updateStu(Student stu) {
		int num = stuService.updateStu(stu);
		if (num > 0) {
			return new ModelAndView("forward:stulist.do", "msg", "修改成功！");
		}
		return null;
	}

	// 根据学生编号查询单个学生
	@RequestMapping("/selectDetails.do")
	public ModelAndView getSingleStu(Integer sno) {
		Student stu = stuService.selectBySno(sno);
		if (stu != null) {
			// 第一个值对比逻辑视图名，第二个值代表要传到页面的key，第三是要传到页面key对应的值
			return new ModelAndView("details", "stu", stu);
		}
		return null;
	}

	// 查询所有
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

	@RequestMapping("/list.do")
	public ModelAndView getListBySname(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
			@RequestParam(value = "sname", required = true, defaultValue = "") String sname) {
		// 声明一个ModelAndView对象
		ModelAndView mv = new ModelAndView();
		// 开始分页
		PageHelper.startPage(page, 3);// 每页显示3条数据
		PageHelper.orderBy("age desc");// 按年龄降序排序，默认是升序
		List<Student> slist = stuService.getListBySname(sname);
		PageInfo<Student> p = new PageInfo<Student>(slist);// 分页信息保存到p中PageInfo
		mv.addObject("page", p);// 分页的数据
		mv.addObject("stulist", slist);// stulist为index.jsp中的值
		mv.addObject("sname", sname);
		mv.setViewName("index");
		return mv;
	}

}
