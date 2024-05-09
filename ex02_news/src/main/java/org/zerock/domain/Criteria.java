package org.zerock.domain;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum;
	private int amount;

	
	public Criteria() {
		
		this(1, 10);
		
	}

	public Criteria(int i, int j) {
		// TODO Auto-generated constructor stub
		
		this.pageNum = i;
		this.amount = j;
	}
}
