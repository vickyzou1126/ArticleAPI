package com.example.demo.events

import com.example.demo.Entities.Article
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.SimpleApplicationEventMulticaster
import org.springframework.stereotype.Service

@Service
class ArticleEventListener : ApplicationListener<ArticleEvent> {
    override fun onApplicationEvent(event: ArticleEvent) {
        val payload = event.source as Article
        println("--start event---")
        println("article id = ${payload.id} content is ${payload.content}")
        println("--end event---")
    }
}

class ArticleEvent(payload:Any) : ApplicationEvent(payload)


@Configuration
public class ListenerConfig {
    @Bean
    fun applicationEventMulticaster(): ApplicationEventMulticaster {
        return SimpleApplicationEventMulticaster()
    }
}
