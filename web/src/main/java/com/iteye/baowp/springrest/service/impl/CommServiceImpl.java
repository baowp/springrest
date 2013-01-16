package com.iteye.baowp.springrest.service.impl;

import org.springframework.stereotype.Service;

import com.iteye.baowp.springrest.service.CommService;

@Service
public class CommServiceImpl implements CommService {

    public void print() {
        System.out.println("commService");

    }

}
