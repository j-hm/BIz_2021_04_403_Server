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
public class FoodVO {	
	private String mf_date;   	//VARCHAR2(10)	NOT NULL
	private String mf_fcode;	//CHAR(7)	NOT NULL
	private Integer mf_count = 0;	//NUMBER	NOT NULL
	
}
