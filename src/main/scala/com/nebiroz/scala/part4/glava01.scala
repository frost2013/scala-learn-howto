package com.nebiroz.scala.part4

import scala.collection.mutable.Map

object glava01 {
	def main(args: Array[String]): Unit = {
		val acc = new ChecksumAccumulatorPublic
		val ecc = new ChecksumAccumulatorPublic
		acc.sum = 3
		println(acc.sum)
		println(ecc.sum)

		val ccc = new ChecksumAccumulatorPrivate
		ccc.add(5)
		println(ccc.checksum())

		println(h1) // должно вывести надпись "()", что означает тип данных Unit
		println(h2) // тоже самое
		println(h3) // в этом написании уже выведет нормальную надпись
		println(h4) // здесь тоже выведется надпись
	}
	def h1() { "Some text in function!" }
	def h2():Unit = "Some text in function!"
	def h3() = "Some text in function!"
	def h4() = { "Some text in function!" }
}

class ChecksumAccumulatorPublic {
	var sum = 0
}

object ChecksumAccumulatorPrivate {
	private val cache = Map[String, Int]()

	def calculate(s: String) = {
		if (cache.contains(s))
			cache(s)
		else {
			val acc = new ChecksumAccumulatorPrivate
			for(c <- s)
				acc.add(c.toByte)
			val cs = acc.checksum()
			cache += (s -> cs)
			cs
		}
	}
}

class ChecksumAccumulatorPrivate {
	private var sum = 0
	def add(b: Byte): Unit = sum += b
	def checksum(): Int = ~(sum & 0xFF) + 1
}
