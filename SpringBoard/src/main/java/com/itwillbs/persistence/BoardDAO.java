package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

/**
 *  서비스 - Mybatis (mapper) 연결하는 객체 
 *  사용되느 쿼리구문을 호출 
 */
public interface BoardDAO {
	
	//글쓰기
	public void boardCreate(BoardVO vo) throws Exception;
	
	//글 목록 조회
	public List<BoardVO> boardListSelect() throws Exception;
	
	//글 내용 조회 동작
	public BoardVO boardSelect(int bno) throws Exception;
	
	//글 조회수 1증가
	public void boardViewcntUpdate(int bno) throws Exception;
	
	//글수정
	public void boardUpdate(BoardVO vo) throws Exception;
	
	//글 삭제
	public void boardDelete(int bno) throws Exception;
	
	//페이징 처리
	public List<BoardVO> boardListPageSelect(int page) throws Exception;
	
	//페이징처리 cri
	public List<BoardVO> boardListCriSelect(Criteria cri) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
}
