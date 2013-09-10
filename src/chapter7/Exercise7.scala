package chapter7

/*
   7: In the preceding exercise, move all imports into the innermost scope possible.
 */
class Exercise7 {

   def run() {
     println("=" * 10 + "Chapter 7: Exercise 7" + "=" * 10)
     import java.util.{HashMap => JavaHashMap}
     val javaMap: JavaHashMap[Int, String] = new JavaHashMap()
     import collection.JavaConversions.mapAsScalaMap
     javaMap += 1 -> "one"
     javaMap += 2 -> "two"
     javaMap += 3 -> "three"
     import collection.mutable.{HashMap => ScalaHashMap}
     val scalaMap: ScalaHashMap[Int, String] = ScalaHashMap.empty

     for ((key, value) <- javaMap) {
       println("javaMap: " + key + "->" + value)
       scalaMap += key -> value
     }

     println(scalaMap.mkString("<",",",">"))
   }
 }
