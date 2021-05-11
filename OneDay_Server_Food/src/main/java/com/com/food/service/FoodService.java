package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.model.MyDTO;

public interface FoodService {
	
	public int insert(FoodVO foodVO);
	public List<MyDTO> selectAll(); //뷰조회
	public List<FoodDTO> findByFood(String f_name); //식품명 조회
	public List<MyDTO> findByDate(String my_date); //날짜별 조회
	public void update();
	public void delete();

}
