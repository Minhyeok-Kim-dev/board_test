package com.edgc.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.edgc.board.mapper.BoardMapper;
import com.edgc.board.model.dto.BoardDto;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.service.BaseApiService;
import com.edgc.common.ifs.CrudInterface;
import com.edgc.login.model.entity.UserInfo;

@Service
public class ReplyApiService extends BaseApiService<BoardApiRequest, BoardApiResponse>{
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		BoardApiRequest body = request.getData();
		
		Board boardInfo = body.getBoard();
		UserInfo userInfo = body.getUserInfo();
		
		Board board = Board.builder()
				.edgcid(userInfo.getEdgcid())
				.edgctype(userInfo.getEdgctype())
				.testid("")
				.reqType("")
				.title("")
				.contents(boardInfo.getContents())
				.parentsIdx(boardInfo.getParentsIdx())
				.depth(boardInfo.getDepth())
				.fileyn("N")
				.status(boardInfo.getStatus())
				.regid(userInfo.getEdgcid())
				.build();
		
		// 트랜잭션 정의, 상태 객체 생성
		TransactionDefinition tranDef = null;
		TransactionStatus tranStat = null;
		
		try {
			// 트랜잭션 설정
			tranDef = new DefaultTransactionDefinition();
			tranStat = transactionManager.getTransaction(tranDef);

			int ret = boardMapper.insertEntity(board);
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
	public Header<BoardApiResponse> read(Header<BoardApiRequest> request) {
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

	private Header<BoardApiResponse> response(Board board) {
		BoardApiResponse body = BoardApiResponse.builder()
				.board(board)
				.build();
		return Header.OK(body);
	}
}
