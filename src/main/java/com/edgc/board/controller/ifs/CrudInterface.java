package com.edgc.board.controller.ifs;

import com.edgc.board.model.network.Header;

public interface CrudInterface<Req, Res> {
	Header<Res> create(Header<Req> request);
	
	Header<Res> readAll();
	
	Header<Res> read(Long id);
	
	Header<Res> update(Header<Req> request);
	
	Header<Res> delete(Long id);
}
