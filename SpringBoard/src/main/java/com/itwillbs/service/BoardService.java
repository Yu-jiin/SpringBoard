package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 *  Controller - DAO 연결하는 역할
 *  컨트롤러가 외부 호출에 종속적인 상황 방지 
 */
public interface BoardService {
	
	// 글쓰기 동작
	public void regist(BoardVO vo) throws Exception;
	
	// 글 리스트 동작
	public List<BoardVO> getList() throws Exception;
	
	// 글 정보 조회 동작
	public BoardVO read(int bno) throws Exception;
	
}