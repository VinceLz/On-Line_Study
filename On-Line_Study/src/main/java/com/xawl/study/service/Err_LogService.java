package com.xawl.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Err_LogDao;
import com.xawl.study.model.Err_Log;

public interface Err_LogService {

	public boolean addLog(Err_Log err_Log);
}
