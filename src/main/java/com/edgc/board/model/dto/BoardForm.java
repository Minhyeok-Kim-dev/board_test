package com.edgc.board.model.dto;

import java.util.ArrayList;

import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.entity.FileEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardForm extends BoardEntity {
	private String company;
	private ArrayList<ReplyForm> replyList;
	private ArrayList<FileEntity> fileList;
}
