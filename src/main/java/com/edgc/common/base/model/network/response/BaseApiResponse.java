package com.edgc.common.base.model.network.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * API Response에 사용되는 공통 정보를 나타냅니다.
 * ApiResponse class 생성시 해당 class를 상속받아 구현합니다.
 * 
 * 
 * Package 구성
 * - domain package > model > network > response 
 *
 * 권장 Lombok annotation
 * - @Getter @Setter @NoArgsConstructor @SuperBuilder @ToString(callSuper = true)
 *
 *    
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
public class BaseApiResponse {
	
}
