package com.example.demo;

import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JpaApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;

    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member member1 = Member.builder().name("홍길동").email("hong@a.com").age(20).build();

        memberRepository.save(member1);

        var member2 = Member.builder().name("홍길순").email("soon@a.com").age(25).build();

        memberRepository.save(member2);

        var article1 = Article.builder().title("집에 가고 싶다").description("야 나두").member(member1).build();

        articleRepository.save(article1);

        var article2 = Article.builder().title("집에 가고 싶다2222").description("야 나두2222").member(member1).build();

        articleRepository.save(article2);


    }
}
