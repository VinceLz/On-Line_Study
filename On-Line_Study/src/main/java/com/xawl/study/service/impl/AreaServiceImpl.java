package com.xawl.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xawl.study.dao.impl.AreaDao;
import com.xawl.study.model.Area;
import com.xawl.study.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	AreaDao ad;
	public List<Area> GetAreaByCity(String cityID) {
		return ad.GetAreaByCity(cityID);
	}
}
