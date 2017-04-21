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
		String count = "5";// 每页显示的数据数量
		String pagecount = "1";// 第几页
		request.getSession().removeAttribute("unique");
		Page page = new Page();
		PageUtil pu = new PageUtil();
		page = PageUtil.createPage(Integer.parseInt(count), 0,
				Integer.parseInt(pagecount));
		
		List<Interest> interestlist = as.findAllInterestPageAttributeNotNull(page);
		int sum = as.CountInterest();// 总数据条数
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
		request.getSession().setAttribute("allinterest", interestlist);

		return "f:/Admin/showallinterest.jsp";
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
		List<Interest> allinterest = as.findAllInterestPageAttributeNotNull(page);

		int sum = as.CountInterest();// 总数据条数
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
		request.getSession().setAttribute("allinterestlist", interestlist);// 取出所有的兴趣，不按照分页获取
		return "f:/Admin/updateinterestinfo.jsp";
	}
	public String yesUpdateInterestInfo(HttpServletRequest request,//管理员完善信息之后确认提交
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
	public String delete(HttpServletRequest request, HttpServletResponse responsse){//删除兴趣
		String id=request.getParameter("id");
		Interest inter=new Interest();
		inter.setId(Integer.parseInt(id));
		as.DeleteInterestById(inter);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
		+ request.getSession().getAttribute("count")
		+ "&page="
		+ request.getSession().getAttribute("page") ;
	}
	public String AddInterestName(HttpServletRequest request, HttpServletResponse responsse){//添加兴趣名称
		String interest=request.getParameter("interestname");
		Interest inter=new Interest();
		inter.setAttribute("无");
		inter.setInterestName(interest);
		inter.setIsuse("否");
		inter.setSrc(" ");
		List<Interest> allinter=as.findAllInterest();//判断要添加的兴趣名称是否存在
		for (int i = 0; i < allinter.size(); i++) {
			if(allinter.get(i).getInterestName().equals(interest)){
				throw new RuntimeException("兴趣名称已存在！！");
			}
		}
		as.AddInterest(inter);
		return "f:/AdminManageInterestServlet?method=showinfo&count="
		+ request.getSession().getAttribute("count")
		+ "&page="
		+ request.getSession().getAttribute("page") ;
	}
	public String AddInterestName1(HttpServletRequest request, HttpServletResponse responsse){//简单的转发
		return "f:/Admin/AddInterestName.jsp";
	}
	public String AddInterest(HttpServletRequest request, HttpServletResponse responsse){//添加兴趣
		List<Interest> interestlist = as.findAllInterestPageAttributeNull();//用于向兴趣表中添加兴趣，不是修改兴趣
		request.getSession().setAttribute("allinterestlist", interestlist);// 取出所有没有详情的兴趣，不按照分页获取
		return "f:/Admin/AddInterest.jsp";
	}
	public String YesAddInterest(HttpServletRequest request, HttpServletResponse responsse){//添加兴趣	
		String interestname=request.getParameter("interestname");
		String attribute=request.getParameter("attribute");
		String isuse=request.getParameter("isuse");
		String src=request.getParameter("src");
		Interest inter=new Interest();
		inter.setInterestName(interestname);
		inter.setAttribute(attribute);
		inter.setIsuse(isuse);
		inter.setSrc(src);
		//实例化逻辑层
		if(as.UpdateInterestByInterestName(inter)){
			return "f:/AdminManageInterestServlet?method=showinfo&count="
					+ request.getSession().getAttribute("count")
					+ "&page="
					+ request.getSession().getAttribute("page") ;
		}
		return null;	
	}
	public String AddInterestCategory(HttpServletRequest request, HttpServletResponse responsse){//添加兴趣分类
		return "f:/Admin/addInterestCategory.jsp";
	}
	public void AddInterestCategoryReal(HttpServletRequest request, HttpServletResponse responsse) throws IOException{//添加兴趣分类
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
		for (int d = 0; d < categoryList.size(); d++) {//循环添加数据到返回的变量里
			sb.append(categoryList.get(d).getCategoryName());
			if(d<(categoryList.size()-1)){
				sb.append(",");
			}
		}
		responsse.getWriter().print(sb);
	}
	//点击添加兴趣细则的时候调用的方法
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
