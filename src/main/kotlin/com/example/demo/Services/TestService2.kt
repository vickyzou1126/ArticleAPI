package com.example.demo.Services

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service;
import java.time.LocalDateTime
import java.util.*

@Service
public class TestService2 {

    @Async
    fun executeAsyncTask(i:Int){
        for(i in 0..10){
            println("step1 = ${i}")
        }
    }
    @Async
    fun executeAsyncTask2(i:Int){
        for(i in 0..10){
            println("step2 = ${i}")
        }
    }

    @Scheduled(fixedRate = 100)
    fun checkVehicle() {
        println(LocalDateTime.now())
    }

}
