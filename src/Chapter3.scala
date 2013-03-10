val header = "=" * 10 + "Chapter 3: Exercise %1$02d" + "=" * 10

/*===============================================*/
println(header.format(1))
/* 1: [Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).]*/

import collection.mutable
import util.Random

val num = Random.nextInt(25)
println("n=" + num)

val a1 = new Array[Int](num)
for (r <- 0 until a1.length) { a1(r) = Random.nextInt(100) }
println("Assigning each: " + a1.mkString("<", ",", ">"))

val a2 = for (r <- 0 until num) yield Random.nextInt(100)
println("Using yield: " + a2.mkString("<", ",", ">"))

/*===============================================*/
println(header.format(2))
/* 2: [Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).] */
val swapArray = Array(1,2,3,4,5)
for (i <- 0 until swapArray.length by 2 if i+1 < swapArray.length) {
  val tmp = swapArray(i)
  swapArray(i) = swapArray(i+1)
  swapArray(i+1) = tmp
}
println("swapped: " + swapArray.mkString("<", ",", ">"))

/*===============================================*/
println(header.format(3))
/* 3: [Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield.] */
val src = Array(1,2,3,4,5)
val swapped = for (i <- 0 until src.length) yield {
  if (i % 2 == 0) {
    if (i+1 < src.length)
      src(i+1)
    else
      src(i)
  } else {
    src(i-1)
  }
}
println("swapped: " + swapped.mkString("<", ",", ">"))

/*===============================================*/
println(header.format(4))
/* 4: [Given an array of integers, produce a new array that contains all positive values of the original array,
    in their original order, followed by all values that are zero or negative, in their original order.] */
def exercise4(src : Array[Int]) : Array[Int] = {
  src.filter(_ > 0) ++ src.filter(_ <= 0)
}

val src4a = Array(1,2,3,4,5)
println(src4a.mkString("<", ",", ">") + " => " + exercise4(src4a).mkString("<", ",", ">"))

val src4b = Array(1,-2,3,4,-5)
println(src4b.mkString("<", ",", ">") + " => " + exercise4(src4b).mkString("<", ",", ">"))

val src4c = Array(-10,6,7,123,-78, 18)
println(src4c.mkString("<", ",", ">") + " => " + exercise4(src4c).mkString("<", ",", ">"))

/** An answer found online, but I like mine better. 'a' is the incoming source array.
val res = ArrayBuffer[Int]()
for (elem <- a if elem > 0) {
  res += elem
}
for (elem <- a if elem <= 0) {
  res += elem
}
*/

/*===============================================*/
println(header.format(5))
/* 5: [How do you compute the average of an Array[Double]?] */
val src5a = Array(1.0, 100.0)
println("Average of " + src5a.mkString("<", ",", ">") + " is " + (src5a.sum / src5a.size))

val src5b = Array(1.0, 100.0, 12.0, 19.0, 1000.0)
println("Average of " + src5b.mkString("<", ",", ">") + " is " + (src5b.sum / src5b.size))

/*===============================================*/
println(header.format(6))
/* 6: [How do you rearrange the elements of an Array[Int] so that they appear in
reverse sorted order? How do you do the same with an ArrayBuffer[Int]?] */
val src6a = Array(1, 100, 25, 17, 34, 89)
println("Sorted+Reverse:" + src6a.sorted.reverse.mkString("<", ",", ">"))
println("SortWith:" + src6a.sortWith(_ > _).mkString("<", ",", ">"))
println("Unchanged:" + src6a.mkString("<", ",", ">"))
scala.util.Sorting.quickSort(src6a)
println("After Quicksort:" + src6a.mkString("<", ",", ">"))
import scala.collection.mutable.ArrayBuffer
val src6b = ArrayBuffer(1, 100, 25, 17, 34, 89, 56)
println("ArrayBuffer:" + src6b.sorted.reverse.mkString("<", ",", ">"))
println("ArrayBuffer(changed?):" + src6b.mkString("<", ",", ">"))
println("ArrayBuffer(sortWith):" + src6b.sortWith(_ > _).mkString("<", ",", ">"))

/*===============================================*/
println(header.format(7))
/* 7: [Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)] */
val src7a = Array(1, 1, 50, 23, 18, 19, 50, 12,19)
println(src7a.distinct.mkString("<", ",", ">"))

/*===============================================*/
println(header.format(8))
/* 8: [Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on
page 32. Collect indexes of the negative elements, reverse the sequence, drop
the last index, and call a.remove(i) for each index. Compare the efficiency of
this approach with the two approaches in Section 3.4.] */
var a = ArrayBuffer(2, -10, 3, -5, 5, -15, 7, 11)
var first = true
var n = a.length
var i = 0
while (i < n) {
  if (a(i) >= 0) i += 1
  else {
    if (first) { first = false; i += 1}
    else { a.remove(i); n -= 1}
  }
}
println("Sequential:" + a.mkString("<", ",", ">"))

// Example from book:
a = ArrayBuffer(2, -10, 3, -5, 5, -15, 7, 11)
first = true
var indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
  if (a(i) < 0) first = false; i
}
for (j <- 0 until indexes.length) a(j) = a(indexes(j))
a.trimEnd(a.length - indexes.length)
println("Example:" + a.mkString("<", ",", ">"))

a = ArrayBuffer(2, -10, 3, -5, 5, -15, 7, 11)
indexes = for (i <- 0 until a.size if a(i) < 0) yield { i }
indexes = indexes.reverse.dropRight(1)
for (j <- 0 until indexes.size) { a.remove(indexes(j)) }
println("Exercise:" + a.mkString("<", ",", ">"))

/*===============================================*/
println(header.format(9))
/* 9: [Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
that are in America. Strip off the "America/" prefix and sort the result.] */
val timezones = java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America")).map(_.stripPrefix("America/")).sorted
timezones.foreach(println(_))

/*===============================================*/
println(header.format(10))
/* 10: [Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as
a Scala buffer. (Why this obscure class? It’s hard to ﬁnd uses of java.util.List in the standard Java library.)] */
import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val natives : mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
println(natives.mkString("<", ",", ">"))
