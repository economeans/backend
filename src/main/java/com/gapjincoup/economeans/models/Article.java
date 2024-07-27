package com.gapjincoup.economeans.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity<ArticleId> {
    @Column(name = "title")
    private String title; // 기사 제목

    @Column(name = "terms", columnDefinition = "json")
    private String terms; // 단어 리스트

    @Transient
    private List<List<String>> list2Term;


    private Article() {
    }

    public Article(ArticleId id, String title, String terms) {
        this.id = id;
        this.title = title;
        this.terms = terms;
    }

    public ArticleId id() {
        return id;
    }

    public String title() {
        return title;
    }

    public List<List<String>> terms() {
        if (list2Term == null && terms != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                list2Term = mapper.readValue(terms, new TypeReference<>() {
                });
            } catch (Exception e) {
                list2Term = List.of();
            }
        }
        return list2Term;
    }
}
