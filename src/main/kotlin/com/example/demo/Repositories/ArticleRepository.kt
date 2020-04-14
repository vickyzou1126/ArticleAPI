package com.example.demo.Repositories

import com.example.demo.Entities.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
public interface ArticleRepository : JpaRepository<Article, Long>
{
    @Query("select a from Article a where lower(a.content) like lower(?1)")
    fun GetArticleContentLike(content:String):List<Article>
}




