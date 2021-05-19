package com.edgc.board.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgc.board.controller.ifs.CrudInterface;
import com.edgc.board.model.network.Header;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.board.service.BoardApiService;

@RestController
@RequestMapping("/api/board")
public class BoardApiController implements CrudInterface<BoardApiRequest, BoardApiResponse> {
	@Autowired
	BoardApiService boardApiService;
	
	@Override
	@PostMapping("")
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		System.out.println("############# create");
		
		return boardApiService.create(request);
	}

	@Override
	public Header<BoardApiResponse> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> update(Header<BoardApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
