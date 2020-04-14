package com.example.demo.Repositories

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object EMF {
    private var emFactory: EntityManagerFactory? = null
    val entityManager: EntityManager
        get() = emFactory!!.createEntityManager()

    fun close() {
        emFactory!!.close()
    }

    init {
        emFactory = Persistence.createEntityManagerFactory("com.example.demo")
    }
}