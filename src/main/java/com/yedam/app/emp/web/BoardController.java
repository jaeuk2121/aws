package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//전체조회	: URI - boardList/ return board/boardlist
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.SelectAllBoard();
		model.addAttribute("boardList", list);
		return "board/boardlist";
	}
	//단건조회	 	boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardInfo",findVO);
		return "board/boardInfo";
	}
	
	//등록 - 페이지	boardinsert
	
	//등록 -처리	boardinsery	retrun- 전체조회 다시 호출
	
	//수정 - 페이지
	
	//수정 - 처리
	
	// 삭제 -처리
}
