package com.edgc.board.model.dto;

import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.login.model.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class BoardDto extends BoardApiRequest {
	private UserInfo userInfo;
}
