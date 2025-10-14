package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 제일 먼저 실행을 하게하는 어노테이션
//@Component 자식 격
    //@Controller
    //@Repository
    //@Service
@RequiredArgsConstructor
@Slf4j // log를 찍기 위함
public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("{}","hello run");

        //create
        /*Member member = Member.builder().name("lim").email("hgd@a.com").age(20).build();
        memberRepository.save( member );

        member.setAge(60);
        memberRepository.save( member );*/

        //이름으로 조회
        List<Member> members = memberRepository.findByName("홍길동");

        if(members.isEmpty()){
            log.info("홍길동 이라는 이름의 회원이 없습니다");
        }else{
            for(Member member : members){
                log.info("조회된 회원 {}", member);
            }
        }

        //이름에 a 가 포함되어 있는 데이터를 조회
        log.info("포함여부 {}", memberRepository.findByNameContaining("i"));

        //이름으로 삭제
        int res = memberRepository.deleteByName("홍길동");

    }//run
}
