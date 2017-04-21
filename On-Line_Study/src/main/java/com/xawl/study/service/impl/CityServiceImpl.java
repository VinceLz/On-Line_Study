package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CityDao;
import com.xawl.study.model.City;
import com.xawl.study.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityDao cd;

	public List<City> GetListByProvince(String provinceID) {
		return cd.GetListByProvince(provinceID);
	}

	public String getCityNameByCityID(String pid) {
		return cd.getCityNameByCityID(pid);
	}
}
