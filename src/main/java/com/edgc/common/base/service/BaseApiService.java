package com.edgc.common.base.service;

import org.springframework.stereotype.Component;

import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.edgc.common.ifs.CrudInterface;

@Component
public abstract class BaseApiService
		<Req extends BaseApiRequest, Res extends BaseApiResponse>
		implements CrudInterface<Req, Res> {

	@Override
	public Header<Res> create(Header<Req> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<Res> read(Header<Req> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<Res> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<Res> update(Header<Req> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<Res> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
