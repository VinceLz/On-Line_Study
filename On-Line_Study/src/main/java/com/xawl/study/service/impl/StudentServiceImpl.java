package com.xawl.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.StudentDao;
import com.xawl.study.model.Page;
import com.xawl.study.model.Student;
import com.xawl.study.model.Teach_Class;
import com.xawl.study.service.StudentService;
import com.xawl.study.util.Md5Util;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao sd;

	public Student StudentLogin(Student student) {// 用户登录验证
		boolean isok = false;

		student.setPwd(Md5Util.createMd5(student.getPwd()));
		Student stu = new Student();
		stu = sd.loginByAccount(student.getAccount(), student.getPwd());
		if (stu != null) {
			return stu;
		}
		stu = sd.loginByEmail(student.getE_mail(), student.getPwd());
		if (stu != null) {
			return stu;
		}
		return stu;
	}

	@SuppressWarnings("static-access")
	public boolean StudnetRegist(Student student) {// 验证用户注册
		boolean isok = false;
		new Md5Util();
		student.setPwd(Md5Util.createMd5(student.getPwd()));
		if (!sd.compUser(student)) {// 首先判断用户是否存在，保证用户账号或者邮箱唯一
			if (sd.addUser(student)) {
				isok = true;
			}
		}
		return isok;
	}

	public Student FindStudentByEmail(Student student) {// 调用Dao方法实现用户信息的查找，按照邮箱
		Student stu = new Student();
		stu = sd.findUserByEmail(student.getE_mail());

		return stu;
	}

	public Student FindStudentByAccount(Student student) {// 调用Dao方法实现用户信息的查找，按照帐号
		Student stu = new Student();
		stu = sd.findUserByAccount(student.getAccount());
		return stu;
	}

	public boolean DeleteStudentByAccount(Student student) {// 按照账号删除用户，接收参数为Student类型
		boolean isok = false;
		if (sd.deleteUserByAccount(student.getAccount())) {
			isok = true;
		}
		return isok;
	}

	public boolean DeleteStudentByEmail(Student student) {// 按照邮箱删除用户，接收参数为Student类型
		boolean isok = false;
		if (sd.deleteUserByEmail(student.getE_mail())) {
			isok = true;
		}
		return isok;
	}

	public boolean UpdateStudentByAccount(Student student) {// 按照账号更新用户信息
		boolean isok = false;
		if (sd.updateUserByAccount(student.getAccount(), student)) {
			isok = true;
		}
		return isok;
	}

	public boolean UpdateStudentByEmail(Student student) {// 按照账号更新用户信息
		boolean isok = false;
		if (sd.updateUserByEmail(student.getE_mail(), student)) {
			isok = true;
		}
		return isok;
	}

	public List<Student> FindAllStudentPage(Page page) {
		List<Student> allstu = new ArrayList<Student>();
		allstu = sd.queryByPage(page);
		return allstu;
	}

	public int CountStudent() {
		return sd.CountStudent();
	}

	@Override
	public List<Teach_Class> findByClassid(String classid) {
		return sd.findByClassid(classid);
	}
}
