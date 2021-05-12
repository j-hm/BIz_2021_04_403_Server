package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodCDTO {
	private String mf_date ;		//	= "섭취일자";
	private String mf_fcode ;		//	= "식품코드";
	private String mf_fname ;		//	= "식품명";
	private Float mf_amt ;			//	= "섭취량";
	private Float mf_once ;			//	= "제공량";
	private Float mf_capa ;		//	= "총내용량";
	private Float mf_cal ;			//	= "에너지";
	private Float mf_protien ;		//	= "단백질";
	private Float mf_fat ;			//	= "지방";
	private Float mf_carbo ;		//	= "탄수화물";
	private Float mf_sugar ;		//	= "총당류";
}
