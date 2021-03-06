package com.xawl.study.service;

import java.util.List;

import com.xawl.study.model.Page;
import com.xawl.study.model.Student;

public interface StudentService {

	public Student StudentLogin(Student student);

	public boolean StudnetRegist(Student student);

	public Student FindStudentByEmail(Student student);

	public Student FindStudentByAccount(Student student);

	public boolean DeleteStudentByAccount(Student student);

	public boolean DeleteStudentByEmail(Student student);

	public boolean UpdateStudentByAccount(Student student);

	public boolean UpdateStudentByEmail(Student student);

	public List<Student> FindAllStudentPage(Page page);

	public int CountStudent();
}
