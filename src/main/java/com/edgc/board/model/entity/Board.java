package com.edgc.board.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Board extends BaseEntity {
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
}
