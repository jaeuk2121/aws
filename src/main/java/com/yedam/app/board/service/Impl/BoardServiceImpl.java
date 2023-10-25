package com.yedam.app.board.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // bean에 등록될시? 등록하기위해서?
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> SelectAllBoard() {
		return boardMapper.SelectAllBoard();
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		
		if(result == 1 ) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = boardMapper.updateBoard(boardVO);
		if(result ==1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("info", boardVO);
		
		return map;
	}

	@Override
	public int deleteBoard(int bNo) {
		return boardMapper.deleteBoard(bNo);
	}

}
