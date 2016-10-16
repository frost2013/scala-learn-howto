package com.nebiroz.scala.part3

/**
  * Created by com.nebiroz on 9/22/16.
  * Использование списков
  */
object Step8 {
  def main(args: Array[String]): Unit = {
    val firstList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("Main list \t\t\t\t\t\t\t => " + firstList)

    // create new List with odd elements
    val oddElements = firstList.filter(el => el % 2 == 0)
    println("Output odd elements in new list \t => " + oddElements)

    // count even elements
    println("Count even elements \t\t\t\t => " + firstList.count(el => el % 2 != 0))

    //concat lists
    val concatList = firstList ::: oddElements
    println("Concat elements => " + concatList)

    //remove 3 elements right and 1 element left
    val removedList = concatList.drop(1).dropRight(3)
    println("Remove 3 elements right and 1 element left => " + removedList)

    //print sort removedList
    println("Sorted list => " + removedList.sortWith((elBefore, elNext) => elBefore < elNext))

    //print tail of list
    println("Tail of removedList => " + removedList.tail)
  }
}
