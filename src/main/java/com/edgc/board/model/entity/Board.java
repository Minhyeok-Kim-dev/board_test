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
	private String edgcid;
	private String edgctype;
	private String testid;
	private String reqType;
	private String title;
	private String contents;
	private Long parentsIdx;
	private int depth;
	private String fileyn;
	private String status;
	private String regdt;
	private String regid;
	private String updt;
	private String upid;
}
