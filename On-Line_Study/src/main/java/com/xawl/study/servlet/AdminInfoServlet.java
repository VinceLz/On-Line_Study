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
		String count = request.getParameter("count");// ÿҳ��ʾ����������
		String pagecount = request.getParameter("page");// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		
		List<Administrator> adminlist = as.queryByPage(page);

		int sum = as.CountAdmin();// ����������
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// ÿҳ��ʾ����������
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

	public String showinfoonly(HttpServletRequest request,// ÿ���������Ĳ˵�����ʱ�����
			HttpServletResponse response) throws IOException {
		String count = "5";// ÿҳ��ʾ����������
		String pagecount = "1";// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		List<Administrator> adminlist = as.queryByPage(page);

		int sum = as.CountAdmin();// ����������
		int num = Integer.parseInt((String) request.getSession().getAttribute(
				"count"));// ÿҳ��ʾ����������
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

	public String change(HttpServletRequest request, HttpServletResponse responsse)// �ӹ���Ա�б��е���޸ĵ�ʱ����ã�������ת���޸�����ҳ��
			throws IOException {
		String count = request.getParameter("count");
		request.getSession().setAttribute("count", count);
		return "f:/AdminInfoServlet?method=showinfo&count="
				+ request.getSession().getAttribute("count") + "&page="
				+ request.getSession().getAttribute("page");
	}

	public String accountsearch(HttpServletRequest request,
			HttpServletResponse response) {
		String count = request.getParameter("count");// ÿҳ��ʾ����������
		String pagecount = "1";// �ڼ�ҳ
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
		int numrank = 2;// ����Ա״̬��ʼ����2��ʾ�ǹ���Ա��0��ʾ��������Ա��1��ʾ��ͨ����Ա
		if ("����".equals(rank)) {
			numrank = 0;
		}
		if ("��ͨ".equals(rank)) {
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
			throw new RuntimeException("���ʧ��!");
		}
	}

	public String update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String acount = request.getParameter("acount");
		Administrator admin = new Administrator();
		admin.setAccount(acount);
		admin = as.FindAdminByAccount(admin);
		request.getSession().setAttribute("updateadmininfo", admin);// �����û�����Ϣ����session�У������Ժ�ȡֵ�޸�
		return "f:/Admin/updateadmininfo.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)// �ӹ���Ա�б���ɾ������Ա
			throws IOException {
		String acount = request.getParameter("acount");
		Administrator admin = new Administrator();
		admin.setAccount(acount);
		if (as.DeleteAdministratorByAccount(admin)) {
			return "f:/AdminInfoServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count") + "&page="
					+ request.getSession().getAttribute("page") ;
		} else {
			throw new RuntimeException("ɾ��ʧ��");
		}
	}

	public String yesupdatemethod(HttpServletRequest request,// ������Աȷ���޸���������Ա��Ϣ��ʱ�����
			HttpServletResponse response) throws IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String rank = request.getParameter("rank");
		String id = request.getParameter("id");
		String picture = request.getParameter("picture");
		String logintime = request.getParameter("logintime");
		int numrank = 2;// ����Ա״̬��ʼ����2��ʾ�ǹ���Ա��0��ʾ��������Ա��1��ʾ��ͨ����Ա
		if ("����".equals(rank)) {
			numrank = 0;
		}
		if ("��ͨ".equals(rank)) {
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
if(account.equals(request.getSession().getAttribute("admin"))){//�ж��޸ĵ��ǲ����Լ�����Ϣ
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
			throw new RuntimeException("�޸�ʧ��!");
		}
	}

	public String MyInfo(HttpServletRequest request,
			HttpServletResponse response) {//��ȡ������Ϣ������ǰ̨��ʾ
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
			HttpServletResponse response){//ת���޸�ͷ��Ľ���
		return "f:/Admin/updateimage.jsp";
	}
	public String ChangPwd(HttpServletRequest request,
			HttpServletResponse response){//ת�ﵽ�޸��������
		return "f:/Admin/ChangPwd.jsp";
	}
	
	public String YesChangePwd(HttpServletRequest request,
			HttpServletResponse response){
		String oldpwd=request.getParameter("oldpwd");//��֤ԭʼ����
		//������¼����
		Administrator a=new Administrator();
		a.setAccount((String)request.getSession().getAttribute("admin"));
		a.setPwd(oldpwd);
		if(as.AdminLogin(a)){
			String newpwd2=request.getParameter("newpwd2");
			String account=request.getParameter("account");
			Administrator admin=new Administrator();
			admin.setPwd(newpwd2);
			admin.setAccount(account);	
			if(as.UpdateAdminPwdByAccount(admin)){//����޸�����ɹ���ת��ʾҳ
				return "f:/Admin/OkPwd.jsp";
			}
		}else{
			return "f:/Admin/Error/OldPwdError.jsp";
		}
		
		
	return null;
	}
	public String OldPwdError(HttpServletRequest request,//�޸�����ʱԭʼ��������������ת��ԭҳ��
			HttpServletResponse response){
		return "f:/Admin/ChangPwd.jsp";
	}
	public String ChangeMyInfo(HttpServletRequest request,//ȡ����Ϣ����ת���޸���Ϣҳ��
			HttpServletResponse response){
		String account=request.getParameter("account");
		Administrator a=new Administrator();
		Administrator admin=new Administrator();
		admin.setAccount(account);
		a=as.FindAdminByAccount(admin);
		request.getSession().setAttribute("myinfo", a);
		return "f:/Admin/ChangeMyInfo.jsp";
	}
	public String YesChangeMyInfo(HttpServletRequest request,//�������Աȷ���޸���Ϣʱ������
			HttpServletResponse response){
		String nikename=request.getParameter("nikename");
		String account=request.getParameter("account");
		String phone=request.getParameter("phone");
		Administrator admin=new Administrator();
		admin.setNikename(nikename);
		admin.setAccount(account);
		admin.setCell(phone);
		if(as.UpdateAdminByAcountForNikeNameAndCell(admin)){//�޸���Ϣ�ɹ����޸�session�еĹ���Ա�ǳ�
			//request.getSession().removeAttribute("nakename");
			request.getSession().setAttribute("nakename", nikename);
		}
		return "f:/AdminInfoServlet?method=MyInfo&account="
		+ account;

	}
}