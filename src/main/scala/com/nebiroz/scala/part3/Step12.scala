package com.nebiroz.scala.part3

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

  def loadLinesWithCounts(name: String): String = {
    if (name != ""){
      import scala.io.Source

      try {
        val lines = Source.fromFile(name).getLines().toList
        var output = ""
        for (line <- lines) {
          output += (if (line.length < 10) " " else "") + line.length + " | " + line + "\n"
        }
        output
      }
      catch{
        case _: Throwable => "Cannot load file"
      }
    }
    else {
      "No filename"
    }
  }

  def main(args: Array[String]): Unit = {
    println(loadLinesFromFile(pathToRecources + "Step12/testLog.txt"))
    println(loadLinesWithCounts(pathToRecources + "Step12/counts.txt"))
  }
}
