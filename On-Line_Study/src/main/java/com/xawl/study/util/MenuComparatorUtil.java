package com.xawl.study.util;

import java.util.Comparator;

import com.xawl.study.model.MenuModel;

public class MenuComparatorUtil implements Comparator<MenuModel>{

	//menuList�ڵ����򹤾�
	//o1<o2 ��-1  ��o1>o2 ��1 ��o1=o2��0
	public int compare(MenuModel o1, MenuModel o2) {
		if(o1.equals(o2)){
			return 0;
		}else if(o1.getMenuOrder() < o2.getMenuOrder()){
			return -1;
		}else if(o1.getMenuOrder() == o2.getMenuOrder()){
			return 0;
		}else{
			return 1;
		}
	}

}
