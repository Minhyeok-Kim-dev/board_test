package com.edgc.board.model.dto;

import com.edgc.board.model.entity.BoardEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ReplyForm extends BoardEntity {
	private String usernm;
}
