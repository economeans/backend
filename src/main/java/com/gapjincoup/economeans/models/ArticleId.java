package com.gapjincoup.economeans.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ArticleId extends EntityId {
    private ArticleId() {
        super();
    }

    public ArticleId(String value) {
        super(value);
    }
}