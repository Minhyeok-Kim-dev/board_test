package com.edgc.board.model.network.parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 게시글 검색에 사용되는 parameter class 입니다.
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
public class Search {
	private String skey;
	private String svalue;
}
