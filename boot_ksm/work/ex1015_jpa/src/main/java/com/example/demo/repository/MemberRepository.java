package com.example.demo.repository;

import com.example.demo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    //findMember('홍길동')
    @Query("SELECT m FROM Member m WHERE m.name=:name") // : 이름 기반의 파라미터 값 받기
    List<Member> findMember(String name);
}
