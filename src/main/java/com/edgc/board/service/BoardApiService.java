package com.edgc.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.edgc.board.controller.ifs.CrudInterface;
import com.edgc.board.mapper.BoardMapper;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.Header;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.login.model.entity.UserInfo;
import com.edgc.util.SessionUtil;

@Service
public class BoardApiService implements CrudInterface<BoardApiRequest, BoardApiResponse> {
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		BoardApiRequest body = request.getData();
		
		// 세션에서 사용자 정보 가져옴
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Board board = Board.builder()
				.userid(userInfo.getUserid())
				.prdNm(body.getPrdNm())
				.type(body.getType())
				.title(body.getTitle())
				.contents(body.getContents())
				.repYn("N")
				.regid(userInfo.getUserid())
				.build();
		
		// 트랜잭션 정의, 상태 객체 생성
		TransactionDefinition tranDef = null;
		TransactionStatus tranStat = null;
		
		try {
			// 트랜잭션 설정
			tranDef = new DefaultTransactionDefinition();
			tranStat = transactionManager.getTransaction(tranDef);

			int ret = boardMapper.insertBoard(board);
			System.out.println("# insert : " + ret);
			System.out.println(board);
			
			// Commit
			transactionManager.commit(tranStat);
		} catch(Exception e) {
			// Rollback
			transactionManager.rollback(tranStat);

			System.out.println(e.getMessage());
		}
		
		return response(board);
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
				.idx(test.getIdx())
				.userid(test.getUserid())
				.prdNm(test.getPrdNm())
				.type(test.getType())
				.title(test.getTitle())
				.contents(test.getContents())
				.regid(test.getRegid())
				.build();
		
		return Header.OK(body);
	}
}
