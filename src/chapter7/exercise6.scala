package chapter7

import java.util.{HashMap => JavaHashMap}
import collection.mutable.{HashMap => ScalaHashMap}
import collection.JavaConversions._

/*
  6: Write a program that copies all elements from a Java hash map into a Scala has map. Use imports to rename both classes.
*/
class Exercise6 {

  def run() {
    println("=" * 10 + "Chapter 7: Exercise 6" + "=" * 10)
    val javaMap: JavaHashMap[Int, String] = new JavaHashMap()
    javaMap.put(1, "one")
    javaMap.put(2, "two")
    javaMap.put(3, "three")
    val scalaMap: ScalaHashMap[Int, String] = ScalaHashMap.empty

    for ((key, value) <- javaMap) {
      println("javaMap: " + key + "->" + value)
      scalaMap += key -> value
    }

    println(scalaMap.mkString("<",",",">"))
  }
}
