package com.xawl.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Res_SupportDao;
import com.xawl.study.model.Res_Support;
import com.xawl.study.service.Res_SupportService;

@Service
/**
 * @author kernel
 *
 */
public class Res_SupportServiceImpl implements Res_SupportService {
	@Autowired
	Res_SupportDao dao;

	public void addRes_Support(Res_Support res) {// ����֧����Ϣ��֧�ֱ���,���޸���Դ���е�֧������
		dao.addRes_Support(res);
		dao.UpdateResSupport(res.getSupport_res());
	}
}
