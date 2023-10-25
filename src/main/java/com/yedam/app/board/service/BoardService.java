package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	// 전체조회
	public List<BoardVO> SelectAllBoard();

	// 단건조회
	public BoardVO selectBoard(BoardVO boardVO);

	// 등록 bno(selectkey), title, contents, writer, image
	public int insertBoard(BoardVO boardVO);

	// 수정 title, contents, writer, updatedate, image
	public Map<String, Object> updateBoard(BoardVO boardVO);

	// 삭제
	public int deleteBoard(int bNo);
}
