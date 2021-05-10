package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MyDTO {
	private String my_date; 	//AS 날짜,
	private String my_fcode; 	//AS 상품코드,
	private String my_name; 	//AS 상품명,
	private Integer my_count = 0; 	//AS 섭취량,
	private Integer my_kcal = 0; 	//AS 칼로리,
	private Integer my_protein = 0; 	//AS 단백질,
	private Integer my_fat = 0;		//AS 지방,
	private Integer my_carb = 0; 		//AS 탄수화물,
	private Integer my_sugar = 0; 		//AS 총당류,
	private Integer my_totalKcal = 0;	 // 섭취량 * 칼로리
}
