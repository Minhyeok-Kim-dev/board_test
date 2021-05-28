package com.edgc.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edgc.common.base.ifs.CrudInterface;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.edgc.common.base.service.BaseApiService;

/**
 * Controller Component 관련 추상클래스입니다.
 * - Controller class 생성시 해당 class를 상속받아 구현합니다.
 * 
 * CrudInterface 기반으로 구성되어 있습니다.
 * - 구현시 BaseApiRequest, BaseApiResponse 상속 class type을 설정해주어야 합니다.
 * 
 * BaseApiService 상속 받은 Service Component를 DI합니다.
 * - 구현 시 BaseApiService class type을 포함 시킬 수 있으며, service field로 참조 가능합니다. (this.service)
 *  
 * 그 외 기능들은 Controller Component와 동일하게 사용 가능합니다.
 * 
 * 
 * Package 구성
 * - domain package > controller
 *    
 *     
 * @author MINHYEOK.KIM
 *
 * @param <S> BaseApiService 상속 class type
 * @param <Req> BaseApiRequest 상속 class type
 * @param <Res> BaseApiResponse 상속 class type
 */

@Component
public abstract class BaseApiController
		<S extends BaseApiService<Req, Res>, Req extends BaseApiRequest, Res extends BaseApiResponse> 
		implements CrudInterface<Req, Res>{
	
	@Autowired(required = false)
	protected S service;

	@Override
	public Header<Res> create(Header<Req> request) {
		return service.create(request);
	}

	@Override
	public Header<Res> readList(Header<Req> request) {
		return service.readList(request);
	}

	@Override
	public Header<Res> read(Long id) {
		return service.read(id);
	}

	@Override
	public Header<Res> update(Header<Req> request) {
		return service.update(request);
	}

	@Override
	public Header<Res> delete(Long id) {
		return delete(id);
	}
}
