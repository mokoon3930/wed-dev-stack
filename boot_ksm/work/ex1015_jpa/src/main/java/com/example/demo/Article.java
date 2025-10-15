package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="article")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name="title", length=100) // varchar(100)
    private String title;

    @Column( name="description", length = 4096)
    private String description;

    @ManyToOne // 1 : 다수
    @JoinColumn( name = "memberId") // Join을 하겠다
    private Member member; // Member 랑


}
