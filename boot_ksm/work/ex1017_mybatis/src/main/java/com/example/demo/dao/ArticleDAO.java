package com.example.demo.dao;

import com.example.demo.vo.ArticleVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {

    // 전체 글 조회
    List<ArticleVO> selectAll();
    
    // 게시글 상세 보기
    ArticleVO showView(Integer id);

    //새글 작성
    int newArticle(ArticleVO vo);

    //새글 삭제
    int deleteArticle(Integer id);

    ArticleVO selectOne(Integer id);

    int editArticle(ArticleVO vo);
}
