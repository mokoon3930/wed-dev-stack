package com.example.demo.mapper;

import com.example.demo.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    //<select id="selectAll"> mapper랑 이름 을 맞춰야함
    List<Member> selectAll();
    int selectAllCount();
    
    //email로 검색한 결과가 한 건도 없다면 
    //Optional.empty()를 반환
    Optional<Member> selectByEmail( String email);
}
