package com.xawl.study.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.xawl.study.model.Res_Support;
@Repository
public class Res_SupportDao extends BaseDaoImpl {// 新增支持信息到支持表中

	public void addRes_Support(Res_Support res) {
		getSessionFactory().getCurrentSession().save(res);

	}

	public void UpdateResSupport(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session
				.createQuery("SELECT distinct   support_account as res FROM Res_Support where support_res="
						+ id);
		@SuppressWarnings("unchecked")
		List<Res_Support> res_Support = query.list();
		int j = res_Support.size();
		Query query1 = session
				.createQuery(" update Resource as r set r.likeSum=" + j
						+ " where r.id=" + id);
		int i = query1.executeUpdate();

		if (i > 0) {
			System.out.println("修改成功");
		}
	}
}
