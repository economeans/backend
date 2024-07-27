package com.gapjincoup.economeans.repositories;

import com.gapjincoup.economeans.models.Article;
import com.gapjincoup.economeans.models.ArticleId;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, ArticleId> {
}
