package com.example.demo.Controllers

import com.example.demo.Entities.Article
import com.example.demo.Repositories.ArticleRepository
import com.example.demo.Repositories.ArticleRepositoryCustom
import com.example.demo.Repositories.ArticleRepositoryImpl
import com.example.demo.Services.ArticleService
import com.example.demo.Services.IArticleService
import com.example.demo.events.ArticleEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ArticleController(private val articleRepository: ArticleRepository,
                        private val repositoryImpl: ArticleRepositoryCustom) {

    @Autowired
    lateinit var articleService: IArticleService

    @Autowired
    private lateinit var applicationEventMulticaster: ApplicationEventMulticaster

    @GetMapping("/testevent")
    fun testevent(): Article {
        var newArticle=Article()
        var event = ArticleEvent(newArticle)
        applicationEventMulticaster.multicastEvent(event)
        return newArticle
    }

    @GetMapping("/autocreate")
    fun autocreate(): Article {
        println("----------")
        return repositoryImpl.ArticleTest()
    }


    @GetMapping("/articles")
    fun getAllArticles(): List<Article> =
            articleRepository.findAll()

    @GetMapping("/getarticlesbycontent/{content}")
    fun getAllArticlesByContent(@PathVariable(value = "content") content: String): List<Article> =
            articleService.GetArticleContentLike(content)

    @GetMapping("/getaarticlesbycontent/{content}")
    fun getAAllArticlesByContent(@PathVariable(value = "content") content: String): Article =
            articleRepository.GetArticleContentLike2(content)


    @PostMapping("/articles")
    fun createNewArticle(@Valid @RequestBody article: Article): Article =
            articleRepository.save(article)


    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/articles/{id}")
    fun updateArticleById(@PathVariable(value = "id") articleId: Long,
                          @Valid @RequestBody newArticle: Article): ResponseEntity<Article> {

        return articleRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Article = existingArticle
                    .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/articles/{id}")
    fun deleteArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Void> {

        return articleRepository.findById(articleId).map { article  ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}