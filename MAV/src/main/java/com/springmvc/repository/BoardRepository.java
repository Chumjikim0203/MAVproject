package com.springmvc.repository;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.Board;

public interface BoardRepository {
    List<Board> findAll();
    Board findById(Long id);
    void updateHits(Long id);
    void delete(Long id);
    void update(Board board);
    int boardCount();
	int save(Board board);
	List<Board> pagingList(Map<String, Integer> pagingParams);
}
