package com.edgc.board.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgc.board.controller.ifs.CrudInterface;
import com.edgc.board.model.network.Header;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.board.service.BoardApiService;
import com.edgc.login.model.entity.UserInfo;
import com.edgc.util.SessionUtil;

@RestController
@RequestMapping("/api/board")
public class BoardApiController implements CrudInterface<BoardApiRequest, BoardApiResponse> {
	@Autowired
	BoardApiService boardApiService;
	
	@Override
	@PostMapping("")
	public Header<BoardApiResponse> create(@RequestBody Header<BoardApiRequest> request) {
		System.out.println("############# create");
		System.out.println(request);
		
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
	public Header<BoardApiResponse> update(@RequestBody Header<BoardApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
