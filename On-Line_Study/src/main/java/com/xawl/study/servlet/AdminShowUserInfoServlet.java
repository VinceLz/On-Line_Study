package com.xawl.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;
import com.xawl.study.model.Student;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.StudentService;
import com.xawl.study.util.PageUtil;

public class AdminShowUserInfoServlet extends BaseServlets {
	@Autowired
	StudentService us;
	@Autowired
	InterestService inters;
	public String showinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String count = request.getParameter("count");// ÿҳ��ʾ����������
		String pagecount = request.getParameter("page");// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
	
		List<Student> allstu = us.FindAllStudentPage(page);
		int sum = us.CountStudent();// ����������
		
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// ÿҳ��ʾ����������
		
		if ((sum % num) == 0) {
			request.getSession().setAttribute("weiye", sum / num);
		} else if(sum<num){
			request.getSession().setAttribute("weiye", 1);
		}else{
			request.getSession().setAttribute("weiye", (sum / num) + 1);
		}
		//request.getSession().setAttribute("weiye", sum / num);
		if ((Integer.parseInt(pagecount) <= sum / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
		}
		request.getSession().setAttribute("alluser", allstu);

		return "f:Admin/showalluser.jsp";
	}
	public String showinfoonly(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {//�Ӳ˵��������û������ʱ����ã�����ķ�����ÿ�β�����ʱ�����
		String count = "5";// ÿҳ��ʾ����������
		String pagecount = "1";// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		List<Student> allstu = us.FindAllStudentPage(page);
		int sum = us.CountStudent();// ����������
		int num = Integer.parseInt("5");// ÿҳ��ʾ����������
		if ((sum % num) == 0) {
			request.getSession().setAttribute("weiye", sum / num);
		} else {
			request.getSession().setAttribute("weiye", (sum / num) + 1);
		}
		request.getSession().setAttribute("weiye", sum / num);
		if ((Integer.parseInt(pagecount) <= sum / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
			request.getSession().setAttribute("count", count);
		}
		request.getSession().setAttribute("alluser", allstu);

		return "f:/Admin/showalluser.jsp";
	}
	public String accountsearch(HttpServletRequest request,HttpServletResponse response){
		String count = request.getParameter("count");// ÿҳ��ʾ����������
		String pagecount = "1";// �ڼ�ҳ
		String account=request.getParameter("account");
		Student stu=new Student();
		stu.setAccount(account);
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		List<Student> allstu=new ArrayList<Student>();
		Student student =us.FindStudentByAccount(stu);
		allstu.add(student);
		request.getSession().setAttribute("alluser", allstu);
		request.getSession().setAttribute("unique", "account");
		return "f:/Admin/showalluser.jsp";
	}
	public String adminadduser(HttpServletRequest request,HttpServletResponse response){
		
		Interest inter=new Interest();
		List<Interest> allinterest=inters.findAllInterest();
		request.getSession().setAttribute("allinterest", allinterest);
		return "f:/Admin/adduser.jsp";
	}
}
