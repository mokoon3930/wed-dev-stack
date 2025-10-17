package com.example.demo.controller;

import com.example.demo.dao.ArticleDAO;
import com.example.demo.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleContorller {

    private final ArticleDAO articleDAO;

    @GetMapping(value = {"/", "/list"})
    public String getArticleList(Model model){

        List<ArticleVO> articles = articleDAO.selectAll();

        model.addAttribute("articles", articles);

        return "article-list";

    }

    @GetMapping("/content")
    public String getView(Model model, Integer id){
        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo);
        return "article-content";
    }

    @GetMapping("/add")
    public String newArticleForm(Model modle, Integer member_id){
        //세글 작성 페이지로 membe_id를 가지고 전환
        modle.addAttribute("member_id", member_id);
        return "article-add";
    }

    @PostMapping("/add")
    public String postNewArticle(ArticleVO vo){
        articleDAO.newArticle(vo);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String getDelete( Integer id ){
        articleDAO.deleteArticle(id);
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String getEdit( Model model, Integer id ){
        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo);
        return "article-edit";
    }

    @PostMapping("/edit")
    public String postEdit(ArticleVO vo){
        articleDAO.editArticle(vo);
        return "redirect:/list";
    }


}
