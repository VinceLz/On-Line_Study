package com.xawl.study.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.model.Interest;
import com.xawl.study.model.Student;
import com.xawl.study.service.CityService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.ProvinceService;
import com.xawl.study.service.StudentService;

public class AdminUpdateUserServlet extends BaseServlets {
	@Autowired
	InterestService inters;
	@Autowired
	StudentService ss;
	@Autowired
	ProvinceService ps;
	@Autowired
	CityService cs;
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String acount = request.getParameter("acount");
		Student stu = new Student();
		stu.setAccount(acount);
	
		stu = ss.FindStudentByAccount(stu);
		// 放入兴趣列表
		
		Interest inter = new Interest();
		List<Interest> allinterest = inters.findAllInterest();
		request.getSession().setAttribute("allinterest", allinterest);

		request.getSession().setAttribute("updatestuinfo", stu);// 单个用户的信息放入session中，便于以后取值修改
		return "f:/Admin/updateuserinfo.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String acount = request.getParameter("acount");
		Student stu = new Student();
		stu.setAccount(acount);
		if (ss.DeleteStudentByAccount(stu)) {
			return "f:/AdminShowUserInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count")
					+ "&page="
					+ request.getSession().getAttribute("page");
		} else {
			throw new RuntimeException("删除失败");
		}
	}

	public String yesupdatemethod(HttpServletRequest request,
			HttpServletResponse response) {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String nickName = request.getParameter("nickname");
		String profession = request.getParameter("profession");
		String sex = request.getParameter("sex");
		System.out.println(sex);
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String e_mail = request.getParameter("email");
		String interest = request.getParameter("interest");
		String degree = request.getParameter("degree");
		String resume = request.getParameter("resume");
		String signature = request.getParameter("signature");
		String date = request.getParameter("date");
		String picture = request.getParameter("picture");

		Student student = new Student();
		student.setAccount(account);
		student.setCity(city);
		student.setDate(date);
		student.setDegree(degree);
		student.setE_mail(e_mail);
		student.setInterest(interest);
		student.setNickName(nickName);
		student.setPicture(picture);
		student.setProfession(profession);
		student.setProvince(province);
		student.setPwd(pwd);
		student.setResume(resume);
		student.setSex(sex);
		student.setSignature(signature);

		if (ss.UpdateStudentByAccount(student)) {
			// responsse.sendRedirect("AdminShowUserInfoServlet?method=showinfo&count="+request.getSession().getAttribute("count")+"&page="+request.getSession().getAttribute("page")+"");
			return "f:/AdminShowUserInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page") + "";
		}else{
			return "f:/Admin/Error/AddUserError.jsp";
		}
	}

	public String adduser(HttpServletRequest request,
			HttpServletResponse response) {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String nickName = request.getParameter("nickname");
		String profession = request.getParameter("profession");
		String sex = request.getParameter("sex");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String e_mail = request.getParameter("email");
		String interest = request.getParameter("interest");
		String degree = request.getParameter("degree");
		String resume = request.getParameter("resume");
		String signature = request.getParameter("signature");
		String date = request.getParameter("date");
		String picture = request.getParameter("picture");
//省市的转化
		
		province=ps.getProvinceNameByID(province);
		
		city=cs.getCityNameByCityID(city);
		
		
		Student student = new Student();
		student.setAccount(account);
		student.setCity(city);
		student.setDate(new Date().toLocaleString());
		student.setDegree(degree);
		student.setE_mail(e_mail);
		student.setInterest(interest);
		student.setNickName(nickName);
		student.setPicture(picture);
		student.setProfession(profession);
		student.setProvince(province);
		student.setPwd(pwd);
		student.setResume(resume);
		student.setSex(sex);
		student.setSignature(signature);

		if (ss.StudnetRegist(student)) {
			// responsse.sendRedirect("AdminShowUserInfoServlet?method=showinfo&count="+request.getSession().getAttribute("count")+"&page="+request.getSession().getAttribute("page")+"");
			return "f:/AdminShowUserInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page") + "";
		}else {
			
			return "f:/Admin/Error/AddUserError.jsp";
		}
	
	}
}
