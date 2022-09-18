package com.unique.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//this class is binding to view (jsp form) 
public class Student {

	
	private int sno;
	private String sname;
	private String sadd;
}

