package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article") // 기본으로 깔고가는 mapping
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = {"","/list"})
    public String getArticleList(Model model){
        List<ArticleDto> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "article-list";
    }

    @GetMapping("/content")
    public String getArticle( Model modle, Long id ){

        modle.addAttribute("article", articleService.findById(id));
        return "article-content";
    }

    //새 글 작성 페이지
    @GetMapping("/add")
    public String articleAdd( Model model, Integer member_id ){
        model.addAttribute("member_id",member_id);
        return "article-add";
    }

    //새 글 등록
    @PostMapping("/add")
    public String postAdd(Model modle, Integer member_id, String title, String description ){
        articleService.addNewArticle(member_id, title, description);
        return "redirect:/article/list";
    }

    //수정을 원하는 게시글 검색
    @GetMapping("/edit")
    public String getEdit( Model model, Long id ){
        ArticleDto dto = articleService.findById(id);
        model.addAttribute("dto", dto);
        return "article-edit";
    }

    //게시글 변경사항 적용(수정)
    @PostMapping("/update")
    public String postUpdate( ArticleDto dto ){

        // 수정할 게시글의 id에 해당하는 dto조회
        ArticleDto articleDto = articleService.findById(dto.getId());
        articleDto.setTitle(dto.getTitle());
        articleDto.setDescription(dto.getDescription());

        articleService.update( articleDto);

        return "redirect:/article/list";
    }

    //게시글 삭제
    @GetMapping("/delete")
    public String postDelete( Long id ){
        articleService.delete( id );
        return "redirect:/article/list";
    }

}
