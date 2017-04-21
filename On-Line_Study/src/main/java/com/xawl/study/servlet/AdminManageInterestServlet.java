package com.xawl.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.servlet.BaseServlet;

import com.xawl.study.dao.impl.InterestDao;
import com.xawl.study.model.Category;
import com.xawl.study.model.Interest;
import com.xawl.study.model.Page;
import com.xawl.study.service.CategoryService;
import com.xawl.study.service.InterestService;
import com.xawl.study.util.PageUtil;

public class AdminManageInterestServlet extends BaseServlets {
	@Autowired
	InterestService as;
	@Autowired
	 CategoryService categoryService;
	public String allinterestonly(HttpServletRequest request,
			HttpServletResponse response) {
		String count = "5";// ÿҳ��ʾ����������
		String pagecount = "1";// �ڼ�ҳ
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		
		List<Interest> interestlist = as.findAllInterestPageAttributeNotNull(page);
		int sum = as.CountInterest();// ����������
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
		request.getSession().setAttribute("allinterest", interestlist);

		return "f:/Admin/showallinterest.jsp";
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
		List<Interest> allinterest = as.findAllInterestPageAttributeNotNull(page);

		int sum = as.CountInterest();// ����������
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
		request.getSession().setAttribute("allinterest", allinterest);

		return "f:/Admin/showallinterest.jsp";
	}

	public String change(HttpServletRequest request, HttpServletResponse responsse)
			throws IOException {
		String count = request.getParameter("count");
		request.getSession().setAttribute("page", "1");
		request.getSession().setAttribute("count", count);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
						+ request.getSession().getAttribute("count")
						+ "&page="
						+ request.getSession().getAttribute("page") ;
	}

	public String update(HttpServletRequest request,
			HttpServletResponse responsse) {
		String id = request.getParameter("id");
		Interest inter = as.findInteresById(Integer.parseInt(id));
		List<Interest> interestlist = as.findAllInterest();
		request.getSession().setAttribute("interestinfoone", inter);
		request.getSession().setAttribute("allinterestlist", interestlist);// ȡ�����е���Ȥ�������շ�ҳ��ȡ
		return "f:/Admin/updateinterestinfo.jsp";
	}
	public String yesUpdateInterestInfo(HttpServletRequest request,//����Ա������Ϣ֮��ȷ���ύ
			HttpServletResponse responsse){
		String id=request.getParameter("id");
		String interestname=request.getParameter("interestname");
		String attribute=request.getParameter("attribute");
		String isuse=request.getParameter("isuse");
		String src=request.getParameter("src");
		Interest interest=new Interest();
		interest.setAttribute(attribute);
		interest.setId(Integer.parseInt(id));
		interest.setInterestName(interestname);
		interest.setIsuse(isuse);
		interest.setSrc(src);
		InterestDao interestdao=new InterestDao();
		
		interestdao.UpdateInterestById(interest);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
				+ request.getSession().getAttribute("count")
				+ "&page="
				+ request.getSession().getAttribute("page") ;
	}
	public String delete(HttpServletRequest request, HttpServletResponse responsse){//ɾ����Ȥ
		String id=request.getParameter("id");
		Interest inter=new Interest();
		inter.setId(Integer.parseInt(id));
		as.DeleteInterestById(inter);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
		+ request.getSession().getAttribute("count")
		+ "&page="
		+ request.getSession().getAttribute("page") ;
	}
	public String AddInterestName(HttpServletRequest request, HttpServletResponse responsse){//�����Ȥ����
		String interest=request.getParameter("interestname");
		Interest inter=new Interest();
		inter.setAttribute("��");
		inter.setInterestName(interest);
		inter.setIsuse("��");
		inter.setSrc(" ");
		List<Interest> allinter=as.findAllInterest();//�ж�Ҫ��ӵ���Ȥ�����Ƿ����
		for (int i = 0; i < allinter.size(); i++) {
			if(allinter.get(i).getInterestName().equals(interest)){
				throw new RuntimeException("��Ȥ�����Ѵ��ڣ���");
			}
		}
		as.AddInterest(inter);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
		+ request.getSession().getAttribute("count")
		+ "&page="
		+ request.getSession().getAttribute("page") ;
	}
	public String AddInterestName1(HttpServletRequest request, HttpServletResponse responsse){//�򵥵�ת��
		return "f:/Admin/AddInterestName.jsp";
	}
	public String AddInterest(HttpServletRequest request, HttpServletResponse responsse){//�����Ȥ
		List<Interest> interestlist = as.findAllInterestPageAttributeNull();//��������Ȥ���������Ȥ�������޸���Ȥ
		request.getSession().setAttribute("allinterestlist", interestlist);// ȡ������û���������Ȥ�������շ�ҳ��ȡ
		return "f:/Admin/AddInterest.jsp";
	}
	public String YesAddInterest(HttpServletRequest request, HttpServletResponse responsse){//�����Ȥ	
		String interestname=request.getParameter("interestname");
		String attribute=request.getParameter("attribute");
		String isuse=request.getParameter("isuse");
		String src=request.getParameter("src");
		Interest inter=new Interest();
		inter.setInterestName(interestname);
		inter.setAttribute(attribute);
		inter.setIsuse(isuse);
		inter.setSrc(src);
		//ʵ�����߼���
		if(as.UpdateInterestByInterestName(inter)){
			return "f:/AdminManageInterestServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count")
					+ "&page="
					+ request.getSession().getAttribute("page") ;
		}
		return null;	
	}
	public String AddInterestCategory(HttpServletRequest request, HttpServletResponse responsse){//�����Ȥ����
		return "f:/Admin/addInterestCategory.jsp";
	}
	public void AddInterestCategoryReal(HttpServletRequest request, HttpServletResponse responsse) throws IOException{//�����Ȥ����
		List<Interest> interestList = as.findAllInterest();
		StringBuffer sb=new StringBuffer();
		for (int d = 0; d < interestList.size(); d++) {
			sb.append(interestList.get(d).getInterestName());
			sb.append(",");
			sb.append(interestList.get(d).getId());
			if(d<(interestList.size()-1)){
				sb.append(",");
			}
		}
		responsse.getWriter().print(sb);
	}
	
	public void findInterestCategory(HttpServletRequest request, HttpServletResponse responsse) throws IOException{
		String id=request.getParameter("inter");	
		List<Category> categoryList=categoryService.findCategoryListByInterestId(Integer.parseInt(id));
		//request.setAttribute("categoryList", categoryList);
		StringBuffer sb=new StringBuffer();
		for (int d = 0; d < categoryList.size(); d++) {//ѭ��������ݵ����صı�����
			sb.append(categoryList.get(d).getCategoryName());
			if(d<(categoryList.size()-1)){
				sb.append(",");
			}
		}
		responsse.getWriter().print(sb);
	}
	//��������Ȥϸ���ʱ����õķ���
	public String addInterestDetailed(HttpServletRequest request, HttpServletResponse responsse) throws IOException{
		String interestDetailed=request.getParameter("interestDetailed");
		String[] arrInter=interestDetailed.split(";");
		String interId=request.getParameter("interestname");
		
		for (int i = 0; i < arrInter.length; i++) {
			Category category=new Category();
			category.setBeLongToInterestID(Integer.parseInt(interId));
			category.setCategoryName(arrInter[i]);
			categoryService.addCategory(category);
		}
		 return "f:AdminManageInterestServlet?method=allinterestonly&count=5&page=1";
	}
}
