package com.example.demo.Services

import org.springframework.stereotype.Service

interface ITest {
    fun addTwo(num1:Int,num2:Int):Int
}

@Service
class Test:ITest{
    override fun addTwo(num1:Int,num2:Int):Int{
        return num1+num2
    }
}

interface ITest2 {
    fun addThree(num1:Int,num2:Int,num3:Int):Int
}

@Service
class Test2:ITest2{
    override fun addThree(num1:Int,num2:Int,num3:Int):Int{
        return num1+num2+num3
    }
}