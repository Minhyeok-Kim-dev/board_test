package com.edgc.board.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Board {
	private Long idx;
	private String userid;
	private String prdNm;
	private String type;
	private String title;
	private String contents;
	private String repYn;
	private String repUserid;
	private String repContents;
	private String repWrtdt;
	private String regdt;
	private String regid;
	private String updt;
	private String upid;
}
