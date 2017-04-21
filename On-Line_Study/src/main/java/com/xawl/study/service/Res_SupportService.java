package com.xawl.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Res_SupportDao;
import com.xawl.study.model.Res_Support;

public interface Res_SupportService {

	public void addRes_Support(Res_Support res);
}
