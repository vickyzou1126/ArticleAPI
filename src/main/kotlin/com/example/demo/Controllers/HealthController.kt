package com.example.demo.Controllers

import com.example.demo.Configurations.TestConfig1
import com.example.demo.Services.ITest
import com.example.demo.Services.ITest2
import com.example.demo.Services.TestService2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.context.annotation.Configuration


@RestController
@RequestMapping("/health")
//@ConditionalOnProperty(  "features.tosum", havingValue = "true")
//@ConditionalOnExpression("!\${features.tosum}")
//@ConditionalOnExpression("\${features.tosum} && !\${features.tosum2}")
class HealthController {
    @Value("\${healthy.check}")
    lateinit var check:String

    @Value("\${features.tosum}")
    lateinit var tosum :String

    @Autowired
    lateinit var test1: ITest

    @Autowired
    lateinit var test2:ITest2

    @Autowired
    lateinit var config: TestConfig1

    @GetMapping("/check")
    fun health():String{
        return check
    }


    @GetMapping("/TestConditionalOnClass")

    fun TestConditionalOnClass():String{

        var sum = test1.addTwo(1,2)
        return "${sum} ${config.check}"
    }

    @Autowired
    lateinit var thread: TestService2

    @GetMapping("/thread")

    fun thread(){
        for(i in 1..10){
            thread.executeAsyncTask(i)
            thread.executeAsyncTask2(i)
            println("------")
            for(j in 0..100000){}
        }
    }
}

