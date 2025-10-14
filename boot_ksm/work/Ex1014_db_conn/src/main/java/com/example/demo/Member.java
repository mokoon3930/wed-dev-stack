package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    //@Table : 현재 클레스에서 db를 연동을 할때 클래스 이름과 동일한 테이블을 찼아 자동으로 매핑
    //@Builder : 복잡한 생성자 대신 직관적이고 가독성이 좋은 방식으로 객체를 생성하기 위한 준비

    @Id // 바로 아래 1개만 기본키로 지정
    private long id;
    private String name;
    private String email;
    private int age;

}
