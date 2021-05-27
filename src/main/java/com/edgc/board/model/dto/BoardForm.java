package com.edgc.board.model.dto;

import java.util.ArrayList;

import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.entity.FileEntity;

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
public class BoardForm extends BoardEntity {
	private String company;
	private ArrayList<ReplyForm> replyList;
	private ArrayList<FileEntity> fileList;
}
