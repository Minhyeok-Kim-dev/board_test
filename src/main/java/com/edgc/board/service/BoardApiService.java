package com.edgc.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.edgc.board.mapper.BoardMapper;
import com.edgc.board.model.dto.BoardDto;
import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.dto.ReplyForm;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.service.BaseApiService;
import com.edgc.common.util.DateUtil;
import com.edgc.common.util.SessionUtil;
import com.edgc.login.model.entity.UserInfo;

@Service
public class BoardApiService extends BaseApiService<BoardApiRequest, BoardApiResponse>{
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		BoardApiRequest body = request.getData();
		
		Board board = body.getBoard();
		UserInfo userInfo = body.getUserInfo();
		
		// parentIdx 존재 유무로 board, reply 구분
		if(board.getParentsIdx() == null) {
			// 게시글
			board = Board.builder()
					.edgcid(userInfo.getEdgcid())
					.edgctype(userInfo.getEdgctype())
					.testid(board.getTestid())
					.reqType(board.getReqType())
					.title(board.getTitle())
					.contents(board.getContents())
					.parentsIdx(0L)
					.depth(0)
					.fileyn(board.getFileyn())
					.status("N")
					.regid(userInfo.getEdgcid())
					.build();			
		} else {
			// 댓글
			board = Board.builder()
					.edgcid(userInfo.getEdgcid())
					.edgctype(userInfo.getEdgctype())
					.testid("")
					.reqType("")
					.title("")
					.contents(board.getContents())
					.parentsIdx(board.getParentsIdx())
					.depth(board.getDepth())
					.fileyn("N")
					.status(board.getStatus())
					.regid(userInfo.getEdgcid())
					.build();
		}
		
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
		BoardApiRequest body = request.getData();
		Search search = body.getSearch();
		Paging paging = body.getPaging();
		ArrayList<Sort> sortList = body.getSort();
		
		// 세션에서 사용자 정보 가져옴 - TODO: AOP 적용
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BoardDto boardDto = BoardDto.builder()
				.search(search)
				.paging(paging)
				.sort(sortList)
				.userInfo(userInfo)
				.build();

		System.out.println("##### Search");
		System.out.println(search);
		int listCnt = boardMapper.selectBoardListCnt(boardDto);
		System.out.println(listCnt);
		
		
		System.out.println("##### Paging");
		
		int cPage = body.getPaging().getCPage();
		int pageSize = body.getPaging().getPageSize();
		int totalPage = (listCnt - 1) / (pageSize + 1);
		
		paging = new Paging(cPage, pageSize, totalPage);
		body.setPaging(paging);
		System.out.println(paging);
		
		System.out.println("##### Sort");
		for(Sort sort : sortList) {
			System.out.println(sort);
		}
		
		ArrayList<BoardForm> boardFormList = boardMapper.selectBoardFormList(boardDto);
		
		for(BoardForm board : boardFormList) {
			System.out.println(board);
		}
		
		return response(paging, boardFormList);
	}

	@Override
	public Header<BoardApiResponse> read(Long idx) {
		BoardDto boardDto = BoardDto.builder()
				.entity(Board.builder().idx(idx).build())
				.build();
		
		BoardForm boardForm = boardMapper.selectBoardFormByIdx(boardDto);
		ArrayList<ReplyForm> replyFormList = boardMapper.selectReplyFormListByBoardIdx(boardDto);
		
		System.out.println("###### boardForm : " + boardForm);
		System.out.println("###### replyForm : ");
		for(ReplyForm r : replyFormList) {
			System.out.println(r);
		}
		
		System.out.println(boardForm);
		
		// TODO Auto-generated method stub
		return response(boardForm);
	}

	@Override
	public Header<BoardApiResponse> update(Header<BoardApiRequest> request) {
		System.out.println("### update");
		System.out.println(request);
		
		BoardApiRequest body = request.getData();
		Board board = body.getBoard();
		
		if(board == null) {
			return Header.Error();
		}
		
		// 세션에서 사용자 정보 가져옴 - TODO: AOP 적용
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return Header.Error();
			}
			
			board.setUpdt(DateUtil.now());
			board.setUpid(userInfo.getEdgcid());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int ret = boardMapper.updateEntity(board);
		System.out.println("result: " + ret);
		
		return response(board);
	}

	@Override
	public Header<BoardApiResponse> delete(Long idx) {
		Board board = Board.builder()
				.idx(idx)
				.build();
		
		// 세션에서 사용자 정보 가져옴 - TODO: AOP 적용
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return Header.Error();
			}
			
			
			board.setUpdt(DateUtil.now());
			board.setUpid(userInfo.getEdgcid());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int ret = boardMapper.deleteEntity(board);
		System.out.println("result: " + ret);
		
		return Header.OK();
	}

	
	private Header<BoardApiResponse> response(Board board) {
		BoardApiResponse body = BoardApiResponse.builder()
				.board(board)
				.build();
		return Header.OK(body);
	}
	
	private Header<BoardApiResponse> response(BoardForm boardForm) {
		BoardApiResponse body = BoardApiResponse.builder()
				.boardForm(boardForm)
				.build();
		return Header.OK(body);
	}
	
	private Header<BoardApiResponse> response(Paging paging, ArrayList<BoardForm> boardList) {
		BoardApiResponse body = BoardApiResponse.builder()
				.paging(paging)
				.boardFormList(boardList)
				.build();
		return Header.OK(body);
	}
}
