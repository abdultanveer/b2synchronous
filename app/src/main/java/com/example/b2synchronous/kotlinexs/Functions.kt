package com.example.b2synchronous.kotlinexs

class Functions {
}

fun read(
    b: String,
    off: Int = 0,
    len: Int = b.length,
) { /*...*/ }

fun multiply(
    fno:Int,
    sno:Int = 1
){}
/*
fun main() {
    println(5 Tensare 3)
  *//*  read("ansari", off = 5, len = 20)
    reformat("abdul", wordSeparator = ',')*//*

}*/

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
) { /*...*/ }

infix fun  Int.Tensare(x: Int): Int = x *10

//here x,y and operation are 3 params
fun calculate(
    x: Int,
    y: Int,
    operation: (Int, Int) -> Int
        ): Int {  // 1
    return operation(x, y)   //it is performing the operation and returning its result[int type]
}

fun sum(x: Int, y: Int) = x + y                                     // 3

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")
}