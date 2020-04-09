package com.example.demo.Entities

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="article")
data class Article (
        @Column(name="id")
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name="title")
        @get: NotBlank
        val title: String = "",

        @Column(name="content")
        @get: NotBlank
        val content: String = ""
)