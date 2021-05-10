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
public class FoodDTO {
	    private String f_code;		//CHAR(7)		PRIMARY KEY,
	    private String f_name;		//nVARCHAR2(125)	NOT NULL,	
	    private Integer f_years = 0;	//NUMBER,		
	    private String f_ccode;	//CHAR(6)	NOT NULL,	
	    private String f_icode;	//CHAR(4)	NOT NULL,	
	    private Integer f_once = 0;		//NUMBER	NOT NULL,	
	    private Integer f_total = 0;	//NUMBER	NOT NULL,	
	    private Integer f_kcal = 0;		//NUMBER,		
	    private Integer f_protein = 0;	//NUMBER,		
	    private Integer f_fat = 0;		//NUMBER,		
	    private Integer f_carb = 0;		//NUMBER,		
	    private Integer f_sugar = 0;	//NUMBER		
}
