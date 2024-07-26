package com.gapjincoup.economeans.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity<ArticleId> {
    private Article() {
    }

    public Article(ArticleId id) {
        this.id = id;
    }
}
