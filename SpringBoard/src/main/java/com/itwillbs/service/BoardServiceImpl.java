package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	// DAO 객체 주입 
	@Inject
	private BoardDAO bdao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public void regist(BoardVO vo) throws Exception { 
		logger.debug(" regist(BoardVO vo) 실행 -> DAO 글쓰기 동작 호출 ");
		bdao.boardCreate(vo);
		logger.debug(" boardCreate 서비스 동작 완료 >> 컨트롤러 이동 ");
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		logger.debug(" List<BoardVO> getList() 실행 -> DAO List 동작 호출 ");
		return bdao.boardListSelect();
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		logger.debug(" read(BoardVO vo) 실행 ");
		return bdao.boardSelect(bno);
	}

	@Override
	public void updateViewcnt(int bno) throws Exception {
		logger.debug(" updateViewcnt(int bno) 실행 ");
		bdao.boardViewcntUpdate(bno);
	}

	

}
