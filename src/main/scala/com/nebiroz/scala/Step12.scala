package com.nebiroz.scala

/**
  * Created by nebiroz on 9/23/16.
  */
object Step12 {
  val pathToRecources = "src/main/resources/"

  def getCurrentDir = new java.io.File(".").getAbsolutePath

  def loadLinesFromFile(name: String): String = {
    if (name != "") {
      import scala.io.Source

      try {
        Source.fromFile(name).getLines.mkString("\n")
      }
      catch{
        case _: Throwable => "Cannot open file"
      }
    }
    else {
      "No filename"
    }
  }
  def main(args: Array[String]): Unit = {
    println(loadLinesFromFile(pathToRecources + "testFile/forStep12.txt"))
  }
}
