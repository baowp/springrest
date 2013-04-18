package com.iteye.baowp.springrest.service.impl;

import org.springframework.stereotype.Service;

import com.iteye.baowp.springrest.models.City;
import com.iteye.baowp.springrest.repository.CityDao;
import com.iteye.baowp.springrest.service.CityService;

@Service
public class CityServiceImpl extends ServiceImpl<City, CityDao> implements
		CityService {

}
