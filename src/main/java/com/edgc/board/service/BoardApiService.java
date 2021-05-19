package com.edgc.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgc.board.controller.ifs.CrudInterface;
import com.edgc.board.mapper.BoardMapper;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.Header;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;

@Service
public class BoardApiService implements CrudInterface<BoardApiRequest, BoardApiResponse> {
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		BoardApiRequest body = request.getData();
		
		Board test = Board.builder()
				.val(body.getVal())
				.build();
		
		int ret = boardMapper.insertBoard(test);
		System.out.println("# insert : " + ret);
		System.out.println(test);
		
		return response(test);
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

	
	private Header<BoardApiResponse> response(Board test) {
		BoardApiResponse body = BoardApiResponse.builder()
				.seq(test.getSeq())
				.val(test.getVal())
				.build();
		
		return Header.OK(body);
	}
}
