package com.nebiroz.scala.part2

/**
  * Created by com.nebiroz on 9/22/16.
  */
object Step6 {

  /**
    * Метод, который в любом случае возвращает тип данных строка
    * @param str Any произвольная строка
    * @return
    */
  def checkString(str: Any): String = str match {
    case s: String    => s
    case d: Double    => d.toString
    case i: Int       => i.toString
    case _            => "no"
  }

  /*
  В этом методе описано умножение переданного аргумента на 3, если это целое число
  Вначале идет попытка преобразовать строку в целое число
  Если получилось - то печатается число умноженное на 3
  Иначе - печатаем просто строку
   */
  def multiplyByThree(x: Any): Unit = {
    try {
      val y: Int = checkString(x).toInt
      println(y * 3)
    }
    catch {
      case numFormat: NumberFormatException     => println(x)
      case _:Throwable                          => println("no")
    }
  }

  /*
  Здесь описан пример использования встроенного foreach для прохода по всем
  элементам массива
   */
  def main(args: Array[String]): Unit = {
    args.foreach(multiplyByThree)
  }
}
