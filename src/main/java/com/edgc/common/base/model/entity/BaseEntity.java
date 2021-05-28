package com.edgc.common.base.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Table에 매핑되는 Entity 공통 정보를 나타냅니다.
 * - Entity class 생성시 해당 class를 상속받아 구현합니다.

 * 
 * Package 구성
 * - domain package > model > entity 
 * 
 * 권장 Lombok annotation
 * - @Getter @Setter @NoArgsConstructor @SuperBuilder @ToString(callSuper = true)
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
public class BaseEntity {
	private String regdt;
	private String regid;
	private String updt;
	private String upid;
}
