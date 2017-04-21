package com.xawl.study.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Administrator;
import com.xawl.study.model.Page;
import com.xawl.study.service.AdminService;
import com.xawl.study.util.PageUtil;

public class AdminInfoServlet extends BaseServlets {
	@Autowired
	AdminService as;
	public String showinfoNoPram(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "f:/Admin/index.jsp";
	}
	public String showinfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String count = request.getParameter("count");// 每页显示的数据数量
		String pagecount = request.getParameter("page");// 第几页
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		
		List<Administrator> adminlist = as.queryByPage(page);

		int sum = as.CountAdmin();// 总数据条数
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// 每页显示的数据数量
		if ((sum % num) == 0) {
			request.getSession().setAttribute("weiye", sum / num);
		} else {
			request.getSession().setAttribute("weiye", (sum / num) + 1);
		}
		//request.getSession().setAttribute("weiye", sum / num);
		if ((Integer.parseInt(pagecount) <= sum / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
		}
		request.getSession().setAttribute("alladmin", adminlist);

		return "f:/Admin/showalladmin.jsp";
	}

	public String showinfoonly(HttpServletRequest request,// 每当单击左侧的菜单栏的时候调用
			HttpServletResponse response) throws IOException {
		String count = "5";// 每页显示的数据数量
		String pagecount = "1";// 第几页
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		List<Administrator> adminlist = as.queryByPage(page);

		int sum = as.CountAdmin();// 总数据条数
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// 每页显示的数据数量
		if ((sum % num) == 0) {
			request.getSession().setAttribute("weiye", sum / num);
		} else {
			request.getSession().setAttribute("weiye", (sum / num) + 1);
		}
		//request.getSession().setAttribute("weiye", sum / num);
		if ((Integer.parseInt(pagecount) <= sum / num)
				&& (Integer.parseInt(pagecount) > 0)) {
			request.getSession().setAttribute("page", pagecount);
			request.getSession().setAttribute("count", count);
		}
		request.getSession().setAttribute("alladmin", adminlist);

		return "f:/Admin/showalladmin.jsp";
	}

	public String change(HttpServletRequest request, HttpServletResponse responsse)// 从管理员列表中点击修改的时候调用，用于跳转到修改详情页面
			throws IOException {
		String count = request.getParameter("count");
		request.getSession().setAttribute("count", count);
		return "f:/AdminInfoServlet?method=showinfo&count="
				+ request.getSession().getAttribute("count") + "&page="
				+ request.getSession().getAttribute("page");
	}

	public String accountsearch(HttpServletRequest request,
			HttpServletResponse response) {
		String count = request.getParameter("count");// 每页显示的数据数量
		String pagecount = "1";// 第几页
		String account = request.getParameter("account");
		Administrator admin = new Administrator();
		admin.setAccount(account);
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		List<Administrator> alladmin = new ArrayList<Administrator>();
		Administrator administrator = as.FindAdminByAccount(admin);
		alladmin.add(administrator);
		request.getSession().setAttribute("alladmin", alladmin);
		request.getSession().setAttribute("unique", "account");
		return "f:/Admin/showalladmin.jsp";
	}

	public String addadmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String rank = request.getParameter("rank");
		int numrank = 2;// 管理员状态初始化，2表示非管理员，0表示超级管理员，1表示普通管理员
		if ("超级".equals(rank)) {
			numrank = 0;
		}
		if ("普通".equals(rank)) {
			numrank = 1;
		}
		String cell = request.getParameter("cell");
		String nikename = request.getParameter("nikename");
		Administrator admin = new Administrator();
		admin.setAccount(account);
		admin.setCell(cell);
		admin.setPicture("header_images/04.jpg");
		admin.setNikename(nikename);
		admin.setPwd(pwd);
		
		admin.setRank(numrank);

		if (as.AddAdmin(admin)) {
			return "f:/AdminInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page") ;
		} else {
			throw new RuntimeException("添加失败!");
		}
	}

	public String update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String acount = request.getParameter("acount");
		Administrator admin = new Administrator();
		admin.setAccount(acount);
		admin = as.FindAdminByAccount(admin);
		request.getSession().setAttribute("updateadmininfo", admin);// 单个用户的信息放入session中，便于以后取值修改
		return "f:/Admin/updateadmininfo.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)// 从管理员列表中删除管理员
			throws IOException {
		String acount = request.getParameter("acount");
		Administrator admin = new Administrator();
		admin.setAccount(acount);
		if (as.DeleteAdministratorByAccount(admin)) {
			return "f:/AdminInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page") ;
		} else {
			throw new RuntimeException("删除失败");
		}
	}

	public String yesupdatemethod(HttpServletRequest request,// 当管理员确定修改其他管理员信息的时候调用
			HttpServletResponse response) throws IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String rank = request.getParameter("rank");
		String id = request.getParameter("id");
		String picture = request.getParameter("picture");
		String logintime = request.getParameter("logintime");
		int numrank = 2;// 管理员状态初始化，2表示非管理员，0表示超级管理员，1表示普通管理员
		if ("超级".equals(rank)) {
			numrank = 0;
		}
		if ("普通".equals(rank)) {
			numrank = 1;
		}
		String cell = request.getParameter("cell");
		String nikename = request.getParameter("nikename");
		Administrator admin = new Administrator();
		admin.setAccount(account);
		admin.setCell(cell);
		admin.setId(Integer.parseInt(id));
		admin.setPicture(picture);
		admin.setNikename(nikename);
if(account.equals(request.getSession().getAttribute("admin"))){//判断修改的是不是自己的信息
	request.getSession().setAttribute("grade", numrank);
		}
		
		admin.setPwd(pwd);
		admin.setLogintime(Integer.parseInt(logintime));
		admin.setRank(numrank);

		if (as.UpdateAdminById(admin)) {
			return "f:/AdminInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page");
		} else {
			throw new RuntimeException("修改失败!");
		}
	}

	public String MyInfo(HttpServletRequest request,
			HttpServletResponse response) {//获取个人信息，用于前台显示
		String account = request.getParameter("account");
		Administrator admin = new Administrator();
		Administrator adminis = new Administrator();
		admin.setAccount(account);
		adminis = as.FindAdminByAccount(admin);
		request.getSession().setAttribute("admininfo", adminis);
		return "f:/Admin/myinfo.jsp";
	}
	
	////////
	public String addadminForword(HttpServletRequest request,
			HttpServletResponse response){
		return "f:/Admin/addadmin.jsp";
	}
	public String updateImageForword(HttpServletRequest request,
			HttpServletResponse response){//转到修改头像的界面
		return "f:/Admin/updateimage.jsp";
	}
	public String ChangPwd(HttpServletRequest request,
			HttpServletResponse response){//转达到修改密码界面
		return "f:/Admin/ChangPwd.jsp";
	}
	
	public String YesChangePwd(HttpServletRequest request,
			HttpServletResponse response){
		String oldpwd=request.getParameter("oldpwd");//验证原始密码
		//构建登录参数
		Administrator a=new Administrator();
		a.setAccount((String)request.getSession().getAttribute("admin"));
		a.setPwd(oldpwd);
		if(as.AdminLogin(a)){
			String newpwd2=request.getParameter("newpwd2");
			String account=request.getParameter("account");
			Administrator admin=new Administrator();
			admin.setPwd(newpwd2);
			admin.setAccount(account);	
			if(as.UpdateAdminPwdByAccount(admin)){//如果修改密码成功跳转提示页
				return "f:/Admin/OkPwd.jsp";
			}
		}else{
			return "f:/Admin/Error/OldPwdError.jsp";
		}
		
		
	return null;
	}
	public String OldPwdError(HttpServletRequest request,//修改密码时原始密码错误情况下跳转到原页面
			HttpServletResponse response){
		return "f:/Admin/ChangPwd.jsp";
	}
	public String ChangeMyInfo(HttpServletRequest request,//取出信息，跳转到修改信息页面
			HttpServletResponse response){
		String account=request.getParameter("account");
		Administrator a=new Administrator();
		Administrator admin=new Administrator();
		admin.setAccount(account);
		a=as.FindAdminByAccount(admin);
		request.getSession().setAttribute("myinfo", a);
		return "f:/Admin/ChangeMyInfo.jsp";
	}
	public String YesChangeMyInfo(HttpServletRequest request,//处理管理员确认修改信息时的请求
			HttpServletResponse response){
		String nikename=request.getParameter("nikename");
		String account=request.getParameter("account");
		String phone=request.getParameter("phone");
		Administrator admin=new Administrator();
		admin.setNikename(nikename);
		admin.setAccount(account);
		admin.setCell(phone);
		if(as.UpdateAdminByAcountForNikeNameAndCell(admin)){//修改信息成功后，修改session中的管理员昵称
			//request.getSession().removeAttribute("nakename");
			request.getSession().setAttribute("nakename", nikename);
		}
		return "f:/AdminInfoServlet?method=MyInfo&account="
		+ account;

	}
}