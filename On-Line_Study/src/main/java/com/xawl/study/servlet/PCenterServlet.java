package com.xawl.study.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.IndexModel;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Student;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.ResourceService;

import cn.itcast.servlet.BaseServlet;

public class PCenterServlet extends BaseServlets {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	MenuService menuService;
	@Autowired
	ResourceService resourceService ;
	@Autowired
	InterestService interestService ;
	@Autowired
	IndexModelService indexModelService;
	public String ForwdCenter_Main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_main.jsp";	
	}
	public String ForwdCenter_ChgPw(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_chgPw.jsp";	
	}
	public String ForwdCenter_Class(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_class.jsp";	
	}
	public String ForwdCenter_Comment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_comment.jsp";	
	}
	public String ForwdCenter_Data(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_data.jsp";	
	}
	public String ForwdCenter_Forum(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_forum.jsp";	
	}
	public String ForwdCenter_Note(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_note.jsp";	
	}
	public String ForwdCenter_Track(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Student studentt=new Student();
		try {
			studentt=(Student) request.getSession().getAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			return "f:/IndexDoorServlet?method=indexDoor";
		}
		if(studentt==null){
			return "f:/IndexDoorServlet?method=indexDoor";
		}
//		//首页方案
//		IndexModel indexModel = new IndexModel();
//		indexModel = indexModelService.findUseModel();
//		request.setAttribute("indexModel", indexModel);
		//菜单
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		
		return "f:/User/Jsp/p_center_track.jsp";	
	}
	
	
}
