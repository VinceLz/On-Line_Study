package com.xawl.study.util;

import java.util.Arrays;
import java.util.List;

public class ImageUtil {
	//��ȡ���·��
	public String getImageSrc(String root,String hex,String savename){
		
		String[] src= root.split("\\\\");
		String dir = src[src.length-1].toString();
		String relativePath = dir + "/" + hex.charAt(0) + "/" + hex.charAt(1)
				+ "/" + savename;
		return relativePath;
	}
	
	//��ȡʵ������·��
	public String getRealPath(String root ,String src){
		String[] src1= root.split("\\\\");
		String dir = src1[src1.length-1].toString();
		
		String realPathTemp1 = src.replace(dir, "/");
		String realPathTemp2 = root + realPathTemp1;
		String realPath = realPathTemp2.replace("\\","/");
		return realPath;
	}
	
	//·����ȡ
	public String getPath(String src,String dir){
		String path = src.replace("../", dir);
		return path;
	}
	
	//��ϸ�����ȡ
	public List<String> getDetail (String attribute){
		String[] detailArray = attribute.split(",");
		List<String> detailList = Arrays.asList(detailArray);
		return detailList;
	}
}
