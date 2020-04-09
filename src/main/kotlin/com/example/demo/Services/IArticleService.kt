package com.example.demo.Services

import com.example.demo.Entities.Article
import com.example.demo.Repositories.ArticleRepository
import org.springframework.stereotype.Service


public  interface  IArticleService{
    fun GetArticleContentLike(content:String):List<Article>
}

@Service
public class ArticleService(private val articleRepository: ArticleRepository) :IArticleService{

    override fun GetArticleContentLike(content: String):List<Article> {
        return articleRepository.GetArticleContentLike(content)
    }
}