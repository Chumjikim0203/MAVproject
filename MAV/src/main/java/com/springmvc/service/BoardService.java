package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Board;
import com.springmvc.domain.Page;

public interface BoardService {
	
	    int save(Board board);

	    List<Board> findAll();

	    Board findById(Long id);

	    void updateHits(Long id);

	    void delete(Long id);

	    void update(Board board);

	    List<Board> pagingList(int page);

	    Page pagingParam(int pages);
}
