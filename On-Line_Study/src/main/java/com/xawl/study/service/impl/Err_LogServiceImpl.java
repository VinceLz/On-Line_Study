package com.xawl.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Err_LogDao;
import com.xawl.study.model.Err_Log;
import com.xawl.study.service.Err_LogService;

@Service
public class Err_LogServiceImpl implements Err_LogService{
	@Autowired
	Err_LogDao dao;
	public boolean addLog(Err_Log err_Log){
		return dao.addLog(err_Log);
	}
}
