package com.kh.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.vo.Film;

@Mapper
public interface FilmMapper { // 구현 시키는 곳이라 interface / class X
	
	List<Film> showFilm(PagingDTO paging);
	int total();
	
}	
