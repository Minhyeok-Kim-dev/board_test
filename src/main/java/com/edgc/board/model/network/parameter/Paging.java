package com.edgc.board.model.network.parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Builder
@ToString
public class Paging {
	@JsonProperty("cPage")	// TODO: camel 자동적용 안되는 이유 확인 필요
	private int cPage;

	private int pageSize;
	private int next10;
	private int prev10;
	private int total;
	private int totalPage;
	
	@JsonIgnore
	private int offset;	// sql limit 절 사용 field
	
	@Builder
	public Paging(int total) {
		int cPage = 1;
		int pageSize = 1000;
		
		this.cPage = cPage;
		this.pageSize = pageSize;
		this.total = total;
		
		this.offset = (cPage - 1) * pageSize;	// offset : 0-based index
	}
	
	@Builder
	public Paging(int cPage, int pageSize, int total) {
		int totalPage = (total - 1) / pageSize + 1;
		int prev10 = (int) Math.floor((cPage - 1) / 10.0) * 10;
	    int next10 = prev10 + 11;
	    
	    this.pageSize = pageSize;
	    this.next10 = next10;
	    this.prev10 = prev10;
	    this.cPage = cPage;
	    this.total = total;
	    this.totalPage = totalPage;
	    
	    this.offset = (cPage - 1) * pageSize;	// offset : 0-based index
	}
	
}
