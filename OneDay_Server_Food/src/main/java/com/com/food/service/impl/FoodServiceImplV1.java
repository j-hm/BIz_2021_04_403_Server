package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.model.MyDTO;
import com.com.food.service.DBContract;
import com.com.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService{

	protected Connection dbConn;
	public FoodServiceImplV1() {
		this.dbConn = DBContract.getDBConnection();	
	}
	
	@Override
	public int insert(FoodVO foodVO) {
		// TODO tbl_myfoods에 데이터 저장 INSERT
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (mf_seq, mf_date, mf_fcode, mf_count) ";
		sql += " VALUES(seq_myfoods.NEXTVAL,?,?,?) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, foodVO.getMf_date());
			pStr.setString(2, foodVO.getMf_fcode());
			pStr.setInt(3, foodVO.getMf_count());
			int result = pStr.executeUpdate();
			pStr.close();
			System.out.println("저장되었습니다");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	protected List<MyDTO> select(PreparedStatement pStr) throws SQLException{
		List<MyDTO> myList = new ArrayList<MyDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			MyDTO myDTO = new MyDTO();
			myDTO.setMy_seq(rSet.getLong("일련번호"));
			myDTO.setMy_date(rSet.getString("날짜"));
			myDTO.setMy_fcode(rSet.getString("상품코드"));
			myDTO.setMy_name(rSet.getString("상품명"));
			myDTO.setMy_count(rSet.getInt("섭취량"));
			myDTO.setMy_protein(rSet.getFloat("단백질"));
			myDTO.setMy_fat(rSet.getFloat("지방"));
			myDTO.setMy_carb(rSet.getFloat("탄수화물"));
			myDTO.setMy_sugar(rSet.getFloat("총당류"));
			myDTO.setMy_totalKcal(rSet.getInt("총섭취칼로리"));
			myList.add(myDTO);
		}
		return myList;
	}
	
	@Override
	public List<MyDTO> selectAll() {
		String sql = " SELECT * FROM view_나의음식데이터 ";
		sql += " ORDER BY 일련번호 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyDTO> myList = this.select(pStr);
			pStr.close();
			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected List<FoodDTO> selectFood(PreparedStatement pStr) throws SQLException{
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setF_code(rSet.getString("식품코드"));
			foodDTO.setF_name(rSet.getString("식품명"));
			foodDTO.setF_ccode(rSet.getString("제조회사"));
			foodDTO.setF_icode(rSet.getString("분류"));
			foodList.add(foodDTO);
		}
		return foodList;
	}
	
	@Override
	public List<FoodDTO> findByFood(String f_name) {
		// TODO 식품명 조회
		String sql = " SELECT 식품코드, 식품명, 제조회사, 분류 ";
		sql += " FROM view_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, f_name);
			List<FoodDTO> foodList = this.selectFood(pStr);
			System.out.println(foodList.toString());
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<MyDTO> findByDate(String my_date) {
		// TODO 날짜로 조회하기
		String sql = " SELECT 일련번호, 날짜, 상품코드, 상품명, ";
		sql += " SUM(섭취량) AS 섭취량 , ";
		sql += " SUM(총섭취칼로리) AS 총섭취칼로리 , ";
		sql += " SUM(단백질) AS 단백질 , SUM(지방) AS 지방 , SUM(총당류) AS 총당류 , SUM(탄수화물) AS 탄수화물  ";
		sql += " FROM view_나의음식데이터 ";
		sql += " WHERE 날짜 = ? ";
		sql += " GROUP BY 일련번호, 날짜, 상품코드, 상품명 ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, my_date);
			List<MyDTO> myList = this.select(pStr);
			System.out.println(myList.toString());
			pStr.close();
			return myList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	

}
