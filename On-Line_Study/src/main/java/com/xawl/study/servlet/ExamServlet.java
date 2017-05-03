package com.xawl.study.servlet;

import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import com.xawl.study.model.Category;
import com.xawl.study.model.Exam;
import com.xawl.study.model.IndexModel;
import com.xawl.study.model.Interest;
import com.xawl.study.model.MenuModel;
import com.xawl.study.model.Page;
import com.xawl.study.model.Paper;
import com.xawl.study.model.Question;
import com.xawl.study.model.Student;
import com.xawl.study.service.CategoryService;
import com.xawl.study.service.CommentService;
import com.xawl.study.service.ExamService;
import com.xawl.study.service.IndexModelService;
import com.xawl.study.service.InterestService;
import com.xawl.study.service.MenuService;
import com.xawl.study.service.Res_SupportService;
import com.xawl.study.service.ResourceService;
import com.xawl.study.service.StudentService;
import com.xawl.study.util.ExamUtil;
import com.xawl.study.util.ImageUtil;
import com.xawl.study.util.PageUtil;

public class ExamServlet extends BaseServlets {
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private IndexModelService indexModelService;
	@Autowired
	private InterestService interestService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	ServletUtil servletUtil;
	@Autowired
	CommentService commentService;
	@Autowired
	StudentService studentService;
	@Autowired
	Res_SupportService res_SupportService;

	@Autowired
	private ExamService examService;

	// ��ת�������б�
	public String showAllExam(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ�������������뵽�û�request��
		// ---��ȡ���õĲ˵�---
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);

		// // ---��ȡ���õ���ҳ����---
		// ImageUtil util = new ImageUtil();
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		//
		// String LogoSrc = indexModel.getLogoImageSrc();
		// String newLogoSrc = LogoSrc;
		// indexModel.setLogoImageSrc(newLogoSrc);
		//
		// request.setAttribute("indexModel", indexModel);

		// ---��ȡ��Ȥ����---
		List<Interest> interestList = interestService.findAllInterest();
		request.setAttribute("interestList", interestList);

		// ---��ȡ��ϸ����---

		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);

		String current = request.getParameter("current");
		if (current == null) {// �״ν����ʱ����ʼ��Ϊ��һҳ
			current = "1";
		}
		Page page = PageUtil.createPage(12, examService.findAllResourceCount(),
				Integer.parseInt(current));
		if (page.getCurrentPage() > page.getTotalPage()) {
			page = PageUtil.createPage(12, examService.findAllResourceCount(),
					page.getTotalPage());
		}
		// ---��ȡ��Դ---
		List<Paper> resourceList = examService.findAllPaper(page);
		for (int i = 0; i < resourceList.size(); i++) {// ���Ƴ���
			resourceList
					.get(i)
					.setPaperName(
							resourceList.get(i).getPaperName().length() > 11 ? resourceList
									.get(i).getPaperName().substring(0, 11)
									+ "...."
									: resourceList.get(i).getPaperName());

		}
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("page", page);
		request.setAttribute("servlet", "ResourceServlet");
		request.setAttribute("method", "showAllResource");
		return "f:/User/Jsp/exam.jsp";

	}

	// ��ת������ҳ��
	public String gotoExam(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		int pid = Integer.parseInt(request.getParameter("pid"));
		// ��ȡ�˴���������
		Paper paper = examService.getByPaper(pid);
		System.out.println(paper.getLengthTime() + "----------");
		List squestionList = new ArrayList();
		List mquestionList = new ArrayList();
		List descList = new ArrayList();
		Set<Question> questionList = paper.getQuestions();
		Iterator<Question> it = questionList.iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if ("1".equals(q.getType())) {
				squestionList.add(q);
			} else if ("2".equals(q.getType())) {
				mquestionList.add(q);
			} else {
				descList.add(q);
			}
		}
		shuffle(squestionList);
		shuffle(mquestionList);
		// shuffle(descList);

		request.setAttribute("paper", paper);
		request.setAttribute("squestionList", squestionList);
		request.setAttribute("mquestionList", mquestionList);

		// request.setAttribute("descList", descList);
		request.setAttribute("servlet", "IndexDoorServlet");
		request.setAttribute("method", "forowdCommentInfo");
		return "f:/User/Jsp/examInfo.jsp";
	}

	// ��ת������ҳ��
	public String exam(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// // ��ҳ����
		// IndexModel indexModel = new IndexModel();
		// indexModel = indexModelService.findUseModel();
		// request.setAttribute("indexModel", indexModel);
		// �˵�
		List<MenuModel> menuList = menuService.findAllUseMenu();
		request.setAttribute("menuList", menuList);
		servletUtil.GetNotRedMessageCountToRequest(request);// ��δ������Ϣ�������뵽�û�request��
		// ���ж��Ƿ�μӹ�������
		Exam exam2 = examService.getExam(
				Integer.parseInt(request.getParameter("exam.paper.id")),
				request.getParameter("exam.student.id"));
		System.out.println((Integer) request.getAttribute("exam.paper.id")
				+ "---" + (String) request.getAttribute("exam.student.id"));
		System.out.println(exam2 + "----------");
		if (exam2 != null) {
			// �Ѿ��μӹ�������
			request.setAttribute("msg", "���Ѿ��μӹ��������⿼����!!");
			return "f:/User/Jsp/examResult.jsp";
		}

		Map<String, String[]> keyMap = request.getParameterMap();
		Iterator<Entry<String, String[]>> it2 = keyMap.entrySet().iterator();
		int totalScore = 0;
		int singleScore = 0;
		int moreScore = 0;
		while (it2.hasNext()) {
			Entry<String, String[]> entry = it2.next();
			String keyStr = entry.getKey();
			String values[] = entry.getValue();
			String key;
			String value = "";
			if (keyStr.equals("exam.student.id")
					|| keyStr.equals("exam.paper.id")
					|| keyStr.equals("method")) {
				continue;
			}
			if (keyStr.split("-")[1].equals("r")) { // ��ѡ��Ŀ
				key = keyStr.split("-")[2];
				value = values[0];
				singleScore += this.calScore(key, value, "1");
			} else { // ��ѡ
				key = keyStr.split("-")[2];
				for (String s : values) {
					value += s + ",";
				}
				value = value.substring(0, value.length() - 1);
				moreScore += this.calScore(key, value, "2");
			}
		}
		Exam exam = new Exam();
		totalScore = singleScore + moreScore;
		exam.setSingleScore(singleScore);
		exam.setMoreScore(moreScore);
		exam.setScore(totalScore);
		exam.setExamDate(new java.util.Date());
		exam.setStudent((Student) request.getSession().getAttribute("user"));
		Paper p = new Paper();
		p.setId(Integer.parseInt(request.getParameter("exam.paper.id")));
		exam.setPaper(p);
		examService.saveExam(exam);
		request.setAttribute("exam", exam);

		return "f:/User/Jsp/examResult.jsp";
	}

	public static <T> void shuffle(List<T> list) {
		int size = list.size();
		Random random = new Random();

		for (int i = 0; i < size; i++) {

			int randomPos = random.nextInt(size);

			T temp = list.get(i);
			list.set(i, list.get(randomPos));
			list.set(randomPos, temp);
		}
	}

	private int calScore(String questionId, String userAnswer, String type)
			throws Exception {
		Question question = examService.getQuestion(Integer
				.parseInt(questionId));
		if (userAnswer.equals(question.getAnswer())) {
			if ("1".equals(type)) {
				return 2;
			} else {
				return 3;
			}
		} else {
			return 0;
		}
	}

	// ��ת������ҳ��
	public String addQuestPre(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��ȡ���е��Ծ�
		List<Paper> list = examService.getAllPaper();
		request.setAttribute("list", list);
		System.out.println(list.size());
		return "f:/Admin/questAdd.jsp";
	}

	// ¼������
	public String addPaper(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String parameter = request.getParameter("type");
		if ("1".equals(parameter)) {
			// ����¼��
			String subject = request.getParameter("subject");// ��Ŀ
			String questiontype = request.getParameter("question.type");// ��Ŀ
			String questionpaperid = request.getParameter("question.paper.id");// ��Ŀ
			String A = request.getParameter("question.optionA");// ��Ŀ
			String B = request.getParameter("question.optionB");// ��Ŀ
			String C = request.getParameter("question.optionC");// ��Ŀ
			String D = request.getParameter("question.optionD");// ��Ŀ
			String E = request.getParameter("question.answer");// ��Ŀ
			Question question = new Question();
			question.setJoinTime(new Date());
			question.setOptionA(A);
			question.setSubject(subject);
			question.setOptionB(B);
			question.setOptionC(C);
			question.setOptionD(D);
			question.setAnswer(E);
			Paper p = new Paper();
			p.setId(Integer.parseInt(questionpaperid));
			question.setPaper(p);
			question.setType(questiontype);
			question.setOptionA(question.getOptionA().replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;"));
			question.setOptionB(question.getOptionB().replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;"));
			question.setOptionC(question.getOptionC().replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;"));
			question.setOptionD(question.getOptionD().replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;"));
			examService.addQuest(question);// ����
			request.setAttribute("result", "��ӳɹ�");
			return "f:/Admin/result.jsp";
		} else {
			// ����¼��
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");

			// ����
			DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024,
					new File("C:/f/temp"));
			// ������
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(100 * 1024);// ���Ƶ����ļ���СΪ100K
			sfu.setSizeMax(1024 * 1024);// ������������СΪ1M

			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);

			String questionpaperid = list.get(0).getString();
			InputStream inputStream = fi.getInputStream();
			List<Question> allExam = ExamUtil.getAllExam(inputStream);
			for (Question q : allExam) {
				q.setJoinTime(new Date());
				Paper p = new Paper();
				p.setId(Integer.parseInt(questionpaperid));
				q.setPaper(p);
				if (q.getAnswer().split(",").length != 1) {
					q.setType("2");
				} else {
					q.setType("1");
				}
				q.setOptionA(q.getOptionA().replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;"));
				q.setOptionB(q.getOptionB().replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;"));
				q.setOptionC(q.getOptionC().replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;"));
				q.setOptionD(q.getOptionD().replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;"));
				examService.addQuest(q);// ����
			}
			inputStream.close();
			request.setAttribute("result", "��ӳɹ�");
			return "f:/Admin/result.jsp";
		}

	}

	// ����ģ��
	public String downExam(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * ����ͷһ���� 1. Content-Type 2. Content-Disposition 3. ���������ļ�������
		 */
		String resouceSrc = request.getRealPath("/resourceFiles/templet.doc");
		String fileName = "templet.doc";
		// Ϊ��ʹ���ؿ�����ʾ�����ļ����Ʋ������룡

		String contentType = this.getServletContext().getMimeType(fileName);// ͨ���ļ����ƻ�ȡMIME����
		String contentDisposition = "attachment;filename=" + fileName;
		// һ����

		// �ļ��ĺ�׺

		FileInputStream input = null;

		input = new FileInputStream(resouceSrc);

		// ����ͷ
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);

		// ��ȡ������Ӧ�˵���
		ServletOutputStream output = response.getOutputStream();

		IOUtils.copy(input, output);// ���������е�����д�뵽������С�

		input.close();
		output.close();
		return null;
	}

}
