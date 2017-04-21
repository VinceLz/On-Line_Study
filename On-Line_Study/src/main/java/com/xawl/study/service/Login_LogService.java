package com.xawl.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.Login_LogDao;
import com.xawl.study.model.Login_Log;

public interface Login_LogService {


	public boolean AddLogin_Log(Login_Log log);
}
