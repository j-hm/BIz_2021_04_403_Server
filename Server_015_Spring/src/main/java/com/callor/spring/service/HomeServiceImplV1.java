package com.callor.spring.service;

import org.springframework.stereotype.Service;

import com.callor.spring.model.MyVO;

@Service
public class HomeServiceImplV1 implements HomeService{

	@Override
	public MyVO findById() {
		MyVO vo = new MyVO();
		vo.setT_name("홍길동");
		vo.setT_tel("010-1111-2222");
		vo.setT_age("12");
		return vo;
	}

}
