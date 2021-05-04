package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BuyerDTO;
import com.callor.book.model.BuyerVO;

/*
 * tbl_buyer 테이블의 CURD
 */
public interface BuyerService {

	public List<BuyerDTO> selectAll();
		public BuyerDTO findById(String bu_code);
		public List<BuyerDTO> findByName(String bu_name);
		public List<BuyerDTO> findByTel(String bu_tel);
		
	public void insert(BuyerVO buyerVO);
	public void update(BuyerVO buyerVO);
	public void delete(String bu_code);
	
}
