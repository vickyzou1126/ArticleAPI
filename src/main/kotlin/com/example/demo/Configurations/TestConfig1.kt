package com.example.demo.Configurations

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration

@Configuration
//@ConditionalOnProperty(  "features.tosum", havingValue = "true")
class TestConfig1 {
    @Value("\${healthy.check}")
    lateinit var check:String
}