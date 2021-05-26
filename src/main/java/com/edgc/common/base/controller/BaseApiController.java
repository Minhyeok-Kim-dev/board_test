package com.edgc.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.edgc.common.base.service.BaseApiService;
import com.edgc.common.ifs.CrudInterface;

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
	public Header<Res> read(Header<Req> request) {
		return service.read(request);
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
