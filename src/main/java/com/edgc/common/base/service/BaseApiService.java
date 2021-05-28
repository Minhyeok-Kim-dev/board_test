package com.edgc.common.base.service;

import org.springframework.stereotype.Component;

import com.edgc.common.base.ifs.CrudInterface;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.common.base.model.network.response.BaseApiResponse;

/**
 * Service Component 관련 추상클래스입니다.
 * - Service class 생성시 해당 class를 상속받아 구현합니다.
 * 
 * CrudInterface 기반으로 구성되어 있습니다.
 * - 구현시 BaseApiRequest, BaseApiResponse 상속 class type을 설정해주어야 합니다.
 * 
 * CRUD 기본 method는 구현 class에서 overriding 하여 사용합니다.
 * 
 * 그 외 기능들은 Service Component와 동일하게 사용 가능합니다.
 * 
 * 
 * Package 구성
 * - domain package > service
 *    
 *    
 * @author MINHYEOK.KIM
 *
 * @param <Req> BaseApiRequest 상속 class type
 * @param <Res> BaseApiResponse 상속 class type
 */

@Component
public abstract class BaseApiService
		<Req extends BaseApiRequest, Res extends BaseApiResponse>
		implements CrudInterface<Req, Res> {

	@Override
	public Header<Res> create(Header<Req> request) {
		return null;
	}

	@Override
	public Header<Res> readList(Header<Req> request) {
		return null;
	}

	@Override
	public Header<Res> read(Long id) {
		return null;
	}

	@Override
	public Header<Res> update(Header<Req> request) {
		return null;
	}

	@Override
	public Header<Res> delete(Long id) {
		return null;
	}
}
