package com.edgc.board.model.network.parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 게시글 정렬에 사용되는 parameter class입니다.
 * 
 * @author MINHYEOK.KIM
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Sort {
	private String column;
	private String alias;
	private String sord;
}
