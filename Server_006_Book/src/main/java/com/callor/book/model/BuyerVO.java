package com.callor.book.model;

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
public class BuyerVO {

	private String bu_code;
	private String bu_name;
	private int bu_birth;
	private String bu_tel;
	private String bu_addr;
}
