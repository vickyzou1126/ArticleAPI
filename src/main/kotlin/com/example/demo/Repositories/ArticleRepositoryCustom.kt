package com.example.demo.Repositories

import com.example.demo.Entities.Article
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
interface  ArticleRepositoryCustom {
    @Transactional
    fun ArticleTest():Article
}

public open class ArticleRepositoryImpl : ArticleRepositoryCustom {

    @PersistenceContext()
    private val entityManager: EntityManager = EMF.entityManager
    @Transactional
    override fun ArticleTest(): Article {
        var article = Article(title = "t",content = "c")
        entityManager.persist(article);
        return article
    }
}

