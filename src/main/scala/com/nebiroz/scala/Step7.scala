package com.nebiroz.scala

/**
  * Created by com.nebiroz on 9/22/16.
  */
object Step7 {
  def main(args: Array[String]): Unit = {
    val greeting = new Array[String](3)
    greeting(0) = "Hello"
    greeting(1) = ", "
    greeting(2) = "World!"

    greeting(0) = "Bye"
    for(i <- 0 to 2)
      print(greeting(i))
  }
}
