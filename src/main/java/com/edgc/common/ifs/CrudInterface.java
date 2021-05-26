package com.edgc.common.ifs;

import com.edgc.common.base.model.network.Header;

public interface CrudInterface<Req, Res> {
	/*
	 * CRUD - default methods
	 */
	Header<Res> create(Header<Req> request);
	
	Header<Res> read(Long id);
	
	Header<Res> update(Header<Req> request);
	
	Header<Res> delete(Long id);
	
	/*
	 * custom methods
	 */
	Header<Res> read(Header<Req> request);
}
