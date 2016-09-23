package com.nebiroz.scala

/**
  * Created by com.nebiroz on 9/22/16.
  * Использование кортежей
  */
object Step9 {
  def main(args: Array[String]): Unit = {
    val pair = (99, "Lucas Costarezzo")
    println("Number of pair => " + pair._1)
    println("Name of number => " + pair._2)
    println("Full output pair => " + pair)
  }
}
