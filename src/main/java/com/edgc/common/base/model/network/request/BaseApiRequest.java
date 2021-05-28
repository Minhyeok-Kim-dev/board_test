package com.edgc.common.base.model.network.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * API Request에 사용되는 공통 정보를 나타냅니다.
 * - ApiRequest class 생성시 해당 class를 상속받아 구현합니다.
 * - 구현된 class는 Header class 내 인자로 사용됩니다.
 * 
 * 
 * Package 구성
 * - domain package > model > network > request 
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
public class BaseApiRequest {
}
