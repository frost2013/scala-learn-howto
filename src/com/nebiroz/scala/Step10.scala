package com.nebiroz.scala

import scala.collection.{immutable, mutable}

/**
  * Created by nebiroz on 9/22/16.
  * Использование множеств и карт (Set and Map)
  */
object Step10 {
  def main(args: Array[String]): Unit = {
    //Set
    var jetSet = immutable.Set("Boeing", "Airbus")
    jetSet += "Lear"
    println("Example set => " + jetSet)
    println("Set.contains Cessna => " + jetSet.contains("Cessna"))

    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet += "Schrec"
    println("Output all elements in movieSet => " + movieSet)

    //Map
    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to the island")
    treasureMap += (2 -> "Find big X on the ground")
    treasureMap += (3 -> "Dig")

    println("Output treasureMap element 2 => " + treasureMap(2))
    println("All elements in treasureMap => " + treasureMap)

    //some tests. Map contains the turple of three elements
    val testMap = Map(
      1 -> (2.3, "Record 1", 2.1),
      2 -> (2.5, "Record 2", 2.2),
      3 -> (2.1, "Record 3", 2.3)
    )
    for (record <- testMap) {
      print("Num. record => " + record._1)
      print(" | Abs => " + record._2._1)
      print(" \\ Name => " + record._2._2)
      print(" \\ Norm => " + record._2._3)
      println(" |")
    }
  }
}
