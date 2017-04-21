package com.xawl.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.CityDao;
import com.xawl.study.model.City;

public interface CityService {

	public List<City> GetListByProvince(String provinceID);

	public String getCityNameByCityID(String pid);
}
