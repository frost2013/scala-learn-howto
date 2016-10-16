package com.nebiroz.scala

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by nebiroz on 9/23/16.
  */
class Step12$Test extends FunSuite with BeforeAndAfterEach {
  val pathToRecources = "src/test/resources/"
  val testLog =
    """
Example test text
This is text should be output from test function
    """
  val testCounts =
"""123
1234
1234567890123
123456
1

1234567
"""

  def generateTestFile(text: String, name: String): Unit = {
    import java.io._

    try {
      val pw = new PrintWriter(new File(pathToRecources + name + ".txt"))
      pw.write(text)
      pw.close()
    }
    catch{
      case notFound:java.io.FileNotFoundException => println("Not found file => " + part3.Step12.getCurrentDir)
    }
  }
  def deleteTestFile(name: String): Unit ={
    import java.io._

    try {
      new File(pathToRecources + name + ".txt").delete()
    }
    catch{
      case _:Throwable => println("File not found")
    }
  }

  override def beforeEach() {
    generateTestFile(testLog, "testLog")
    generateTestFile(testCounts, "testCounts")
  }

  override def afterEach(): Unit = {
    deleteTestFile("testLog")
    deleteTestFile("testCounts")
  }

  test("testLoadLinesFromFile сравнение текста") {
    val test = part3.Step12.loadLinesFromFile(pathToRecources + "testLog.txt")
    assert(test == testLog)
  }

  test("testLoadLinesFromFile файл не найден") {
    try {
      val test = part3.Step12.loadLinesFromFile(pathToRecources + "testNotFound.txt")
      assert(test == "Cannot open file")
    }
    catch{
      case _: Throwable => assert(1 == 0)
    }
  }

  test("testLoadLinesFromFile нет имени файла") {
    try {
      val test = part3.Step12.loadLinesFromFile("")
      assert(test == "No filename")
    }
    catch{
      case _: Throwable => assert(1 == 0)
    }
  }

  test("testLoadLinesWithCounts правильное кол-во символом слева") {
    try {
      val test = part3.Step12.loadLinesWithCounts(pathToRecources + "testCounts.txt")

      for (line <- test.split("\n")){
        val pair = line.toString.trim.split("\\|").toList
        if (pair.head.trim.toInt > 0){
          if (pair.head.trim.toInt != pair(1).trim.length){
            assert(1 != 1)
          }
        }
      }
      assert(1 == 1)
    }
    catch{
      case e: Throwable => println(e); assert(1 != 1)
    }
  }
}
