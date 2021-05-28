package com.edgc.board.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * BOARD table entity입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class BoardEntity extends BaseEntity {
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
