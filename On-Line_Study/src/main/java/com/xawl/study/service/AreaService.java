package com.xawl.study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xawl.study.model.Area;

@Service
public interface AreaService {
	public List<Area> GetAreaByCity(String cityID);
}
