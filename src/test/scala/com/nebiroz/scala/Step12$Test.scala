package com.nebiroz.scala

import org.scalatest.{BeforeAndAfterEach, FunSuite}

/**
  * Created by nebiroz on 9/23/16.
  */
class Step12$Test extends FunSuite with BeforeAndAfterEach {
  val pathToRecources = "src/test/resources/"
  val testText =
    """
Example test text
This is text should be output from test function
    """

  def generateTestFile(): Unit = {
    import java.io._

    try {
      val pw = new PrintWriter(new File(pathToRecources + "test.txt"))
      pw.write(testText)
      pw.close()
    }
    catch{
      case notFound:java.io.FileNotFoundException => println("Not found file => " + Step12.getCurrentDir)
    }
  }
  def deleteTestFile(): Unit ={
    import java.io._

    new File(pathToRecources + "test.txt").delete()
  }

  override def beforeEach() {
    generateTestFile()
  }

  override def afterEach(): Unit = {
    deleteTestFile()
  }

  test("testLoadLinesFromFile compare text") {
    val test = Step12.loadLinesFromFile(pathToRecources + "test.txt")
    assert(test == testText)
  }

  test("testLoadLinesFromFile file not found") {
    try {
      val test = Step12.loadLinesFromFile(pathToRecources + "testNotFound.txt")
      assert(test == "Cannot open file")
    }
    catch{
      case _: Throwable => assert(1 == 0)
    }
  }

  test("testLoadLinesFromFile no filename") {
    try {
      val test = Step12.loadLinesFromFile("")
      assert(test == "No filename")
    }
    catch{
      case _: Throwable => assert(1 == 0)
    }
  }

}
