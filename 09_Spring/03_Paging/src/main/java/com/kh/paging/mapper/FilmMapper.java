package com.kh.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.paging.model.vo.Film;

@Mapper
public interface FilmMapper {
	
	List<Film> showFilm();
}	
