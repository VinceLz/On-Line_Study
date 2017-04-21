package com.xawl.study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Acc_LogDao;
import com.xawl.study.model.Acc_Log;
import com.xawl.study.service.Acc_LogService;

@Service
public class Acc_LogServiceImpl implements Acc_LogService {
	@Autowired
	Acc_LogDao acc_LogDao;

	public boolean AddLogin_Log(Acc_Log log) {// 添加访问日志
		return acc_LogDao.AddAcc_Log(log);
	}

}
