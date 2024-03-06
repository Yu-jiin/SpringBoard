package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	// 서비스 객체 주입
	@Inject
	private BoardService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// http://localhost:8088/board/register
	// 글쓰기 GET : /board/register  
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.debug(" registerGET() 호출 ");
		logger.debug(" /board/register.jsp 뷰 연결 ");
	}
	
	// 글쓰기 POST : /board/register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) throws Exception{
		logger.debug(" registerPOST() 호출 ");
		// 한글처리 필터했기 때문에 생략
		// 전달정보(글 정보) 저장
		logger.debug(" 전달정보 : "+vo);
		// 서비스 -> DAO 글쓰기 동작 호출 
		bService.regist(vo);
		logger.debug(" 글쓰기 완료 ! >> list.jsp로 이동 ");
		// 페이지 이동(list)
		return "redirect:/board/listCri";
	}
	
	// http://localhost:8088/board/list
	// 리스트 GET : /board/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model, HttpSession session) throws Exception{
		logger.debug(" listGET() 호출 ");
		// 서비스 -> DAO 게시판 글 목록 가져오기 
		List<BoardVO> boardList = bService.getList();
		logger.debug(" list.size : "+boardList.size());
		// 연결된 뷰 페이지에 정보 전달 (Model)
		model.addAttribute("boardList",boardList);
		
		// 조회수 상태 0 : 조회수 증가X / 1 : 조회수 증가O 
		session.setAttribute("viewUpdateStatus", 1);
	}
	
	
	// 본문읽기 GET : /board/read?bno=?&page=?&pageSize=?
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readGET(int bno, Model model, HttpSession session,Criteria cri) throws Exception{ // @RequestParam, @ModelAttribute 가능 
		// @ModelAttribute : 파라메터 저장 + 영역저장 (1:N관계)
		// @RequestParam : 파라메터 저장 (1:1관계)
		logger.debug(" readGET() 호출 ");
		// 전달정보 저장
		logger.debug(" bno : " +bno);
		
		int status = (Integer)session.getAttribute("viewUpdateStatus");
		if(status == 1) {
			// 글 조회수 1 증가
			bService.updateViewcnt(bno);
			// 조회수 상태 0으로 만들기
			session.setAttribute("viewUpdateStatus", 0);
		}
		
		// 서비스 - DAO 게시판 글 정보 조회 동작
		BoardVO vo = bService.read(bno);
		// 해당정보 저장 -> 연결된 뷰 페이지로 전달
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri); // 뷰 페이지로 페이징처리 정보 전달
		// 뷰 페이지로 이동 
	}
	
	
	// 본문수정 GET /board/modify?bno=??
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model,Criteria cri) throws Exception{
		logger.debug(" modifyGET() 실행 @@@@@@@@@@@@ ");
		logger.debug(" bno : "+bno);
		// 서비스 -> DAO 특정 글 정보 조회 동작
		model.addAttribute(bService.read(bno));
		model.addAttribute("cri", cri);
		// 연결된 뷰 페이지에 전달
	}
	
	
	// 본문수정 POST 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,Criteria cri) throws Exception{
		logger.debug(" modifyPOST() 실행 @@@@@@@@@@@@ ");
		logger.debug(" BoardVO : "+vo);
		// 서비스 -> DAO 
		bService.modify(vo);
		// 수정 완료 후 list로 이동 redirect
		return "redirect:/board/listCri?page="+cri.getPage()+"&pageSize="+cri.getPageSize();
	}
	
	
	
	// 본문삭제 POST
	@RequestMapping(value = "/remove", method =  RequestMethod.POST)
	public String removePOST(BoardVO vo,@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.debug(" removePOST(BoardVO vo) 실행 ");
		bService.remove(bno);
		// return "redirect:/board/listCri";
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("pageSize", cri.getPageSize());
		return "redirect:/board/listCri?page="+cri.getPage()+"&pageSize="+cri.getPageSize();
	}
	
	// http://localhost:8088/board/listCri
	// http://localhost:8088/board/listCri?page=2&pageSize=20
	// 리스트 GET : /board/listCri
		@RequestMapping(value = "/listCri", method = RequestMethod.GET)
		public void listCriGET(Model model, HttpSession session, Criteria cri) throws Exception{
			logger.debug(" listCriGET() 호출 ");
			
			// 페이징처리 객체
		/*
		 * Criteria cri = new Criteria(); 
		 * cri.setPageSize(20); // 글 20개씩 보기
		 */			
			// 서비스 -> DAO 게시판 글 목록 가져오기 
			// List<BoardVO> boardList = bService.getList(); 전체 목록 부르기
			List<BoardVO> boardList = bService.getListCri(cri); // 페이징 처리 목록 
			
			
			logger.debug(" list.size : "+boardList.size());
			// 연결된 뷰 페이지에 정보 전달 (Model)
			model.addAttribute("boardList",boardList);
			model.addAttribute("cri", cri);
			
			// 조회수 상태 0 : 조회수 증가X / 1 : 조회수 증가O 
			session.setAttribute("viewUpdateStatus", 1);
		}
	
	
	
	
	
	
	
	
	
	
	
}
