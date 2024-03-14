package com.springmvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Board;
import com.springmvc.domain.Page;
import com.springmvc.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
		@Autowired
	    private  BoardRepository boardRepository;
		
	    public int save(Board board) {
	        return boardRepository.save(board);
	    }

	    public List<Board> findAll() {
	        return boardRepository.findAll();
	    }

	    public Board findById(Long id) {
	        return boardRepository.findById(id);
	    }

	    public void updateHits(Long id) {
	        boardRepository.updateHits(id);
	    }

	    public void delete(Long id) {
	        boardRepository.delete(id);
	    }

	    public void update(Board board) {
	        boardRepository.update(board);
	    }

	    int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
	    int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수
	    public List<Board> pagingList(int page) {
	        /*
	        1페이지당 보여지는 글 갯수 3
	            1page => 0
	            2page => 3
	            3page => 6
	         */
	        int pagingStart = (page - 1) * pageLimit;
	        Map<String, Integer> pagingParams = new HashMap<>();
	        pagingParams.put("start", pagingStart);
	        pagingParams.put("limit", pageLimit);
	        List<Board> pagingList = boardRepository.pagingList(pagingParams);

	        return pagingList;
	    }

	    public Page pagingParam(int pages) {
	        // 전체 글 갯수 조회
	        int boardCount = boardRepository.boardCount();
	        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
	        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
	        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
	        int startPage = (((int)(Math.ceil((double) pages / blockLimit))) - 1) * blockLimit + 1;
	        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
	        int endPage = startPage + blockLimit - 1;
	        if (endPage > maxPage) {
	            endPage = maxPage;
	        }
	        Page page = new Page();
	        page.setPage(pages);
	        page.setMaxPage(maxPage);
	        page.setStartPage(startPage);
	        page.setEndPage(endPage);
	        return page;
	    }
}