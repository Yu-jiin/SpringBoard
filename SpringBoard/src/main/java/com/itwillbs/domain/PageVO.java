package com.itwillbs.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 페이징처리 하단블럭 
public class PageVO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PageVO.class);

	private int totalCount;	 // 전체 글의 수 
	private int startPage;	 // 블럭 시작 번호
	private int endPage;	 // 블럭 끝 번호
	
	private boolean prev; // 이전 버튼
	private boolean next; // 다음 버튼 
	
	private int pageBlock = 10; // 페이지 블럭의 개수 
	
	//private int page; 		// 페이지 번호
	//private int pageSize;	// 페이지 사이즈
	private Criteria cri;


	/////////////////////// 변수 선언 ////////////////////////////////
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		logger.debug("  페이징 처리에 필요한 정보를 계산 시작  ");
		pageCalc();
		logger.debug("  페이징 처리에 필요한 정보를 계산 끝  ");
	} // setTotalCount()
	
	public void pageCalc() {
		// endPage
		endPage = (int) Math.ceil(cri.getPage() / (double) pageBlock) * pageBlock;
		// startPage
		startPage = (endPage - pageBlock) + 1;

		// tmpEndPage(실제 endPage)
		int tmpEndPage = (int) Math.ceil(totalCount / (double) cri.getPageSize());
		if (endPage > tmpEndPage) { // 글이 없음 모지람
			endPage = tmpEndPage;
		}
		// prev
		prev = startPage != 1;
		// next
		next = endPage * cri.getPageSize() < totalCount;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public Criteria getCri() {
		return cri;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", pageBlock=" + pageBlock + ", cri=" + cri + "]";
	}


	
	
	
	
	
	
}
