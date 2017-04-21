package com.xawl.study.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

public class FileUploadServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File("C:/f/temp"));
		// ������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(100 * 1024);//���Ƶ����ļ���СΪ100K
		sfu.setSizeMax(1024 * 1024);//������������СΪ1M
		
		// �������õ�List
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);
	
			/*
			 * 1. �õ��ļ������·��
			 */
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			/*
			 * 2. ���ɶ���Ŀ¼
			 *   1). �õ��ļ�����
			 *   2). �õ�hashCode
			 *   3). ת����16����
			 *   4). ��ȡǰ�����ַ���������Ŀ¼
			 */
			String filename = fi.getName();//��ȡ�ϴ����ļ�����
			/*
			 * �����ļ����ľ���·������
			 */
			int index = filename.lastIndexOf("\\");
			if(index != -1) {
				filename = filename.substring(index+1);
			}
			/*
			 * ���ļ��������uuidǰ׺�������ļ�ͬ������
			 */
			String savename = CommonUtils.uuid() + "_" + filename;
			
			/*
			 * 1. �õ�hashCode
			 */
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);
			
			/*
			 * 2. ��ȡhex��ǰ������ĸ����root������һ������һ��������·��
			 */
			File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
			
			/*
			 * 3. ����Ŀ¼��
			 */
			dirFile.mkdirs();
			
			/*
			 * 4. ����Ŀ¼�ļ�
			 */
			File destFile = new File(dirFile, savename);
			
			/*
			 * 5. ����
			 */
			fi.write(destFile);
			
			request.setAttribute("msg", "�ϴ�"+ filename +"�ɹ���");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			///////////////////////////////////////////////////////
			
			
		} catch (FileUploadException e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "���ϴ����ļ�������100KB��");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
