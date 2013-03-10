val header = "=" * 10 + "Chapter 4: Exercise %1$02d" + "=" * 10

/*===================================================================*/
println(header.format(1))
/* Set up a map of prices for a number of gizmos that you covet. Then
produce a second map with the same keys and the prices at a 10% discount. */
val gizmos = Map("Galaxy S3" -> 300, "Kindle Fire HD" -> 250, "Blichmann TopTier" -> 1500, "MacBook Pro" -> 3500)
val discountedGizmos = for ((k, v) <- gizmos) yield (k, v * 0.9)
println(gizmos.mkString("<",",",">"))
println(discountedGizmos.mkString("<",",",">"))

/*===================================================================*/
println(header.format(2))
/* 2: [Write a program that reads words from a ﬁle. Use a mutable map to count
how often each word appears. To read the words, simply use a java.util.Scanner:
    val in = new java.util.Scanner(new java.io.File("myfile.txt"))
    while (in.hasNext()) process in.next()
Or look at Chapter 9 for a Scala-esque way.
At the end, print out all words and their counts.] */
val wordCounts = new collection.mutable.HashMap[String, Int]
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext) {
  val word = in.next
  val count = wordCounts.getOrElse(word, 0) + 1
  wordCounts += word -> count
}
wordCounts foreach println _

/*===================================================================*/
println(header.format(3))
/* 3: [Repeat the preceding exercise with an immutable map.] */
println("Using recursive function")

import collection.mutable
import java.util.Scanner
def func(in: Scanner): collection.immutable.Map[String, Int] = {
  val word = in.next()
  if (in.hasNext) {
    val counts = func(in)
    counts + (word -> (counts.getOrElse(word, 0) + 1))
  } else {
    Map(word -> 1)
  }
}

val in3 = new Scanner(new java.io.File("myfile.txt"))
func(in3) foreach println _

println("Using foldLeft")
import collection.JavaConversions.asScalaIterator
val in3b = new Scanner(new java.io.File("myfile.txt"))
val counts = in3b.foldLeft(Map[String, Int]()) {
  (counts, word) => counts + (word -> (counts.getOrElse(word, 0) + 1))
}
counts foreach println _

/*===================================================================*/
println(header.format(4))
/* 4: [Repeat the preceding exercise with a sorted map, so that the words are
printed in sorted order.] */
import collection.immutable.SortedMap
import collection.JavaConversions.asScalaIterator
val in4 = new Scanner(new java.io.File("myfile.txt"))
val counts4 = in4.foldLeft(SortedMap[String, Int]()) {
  (counts, word) => counts + (word -> (counts.getOrElse(word, 0) + 1))
}
counts4 foreach println _

/*===================================================================*/
println(header.format(5))
/* 5: [Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
Scala API.] */
import collection.JavaConversions.mapAsScalaMap
val in5 = new Scanner(new java.io.File("myfile.txt"))
val counts5 = in5.foldLeft(new java.util.TreeMap[String, Int]()) {
  (counts, word) => counts.put(word, counts.get(word) + 1); counts
}
counts5 foreach println _


/*===================================================================*/
println(header.format(6))
/* 6: [Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
similarly for the other weekdays. Demonstrate that the elements are visited
in insertion order.] */
val days = mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY ,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY,
  "Sunday" -> java.util.Calendar.SUNDAY
)
days foreach println _

/*===================================================================*/
println(header.format(7))
/* 7: [Print a table of all Java properties, like this:
  java.runtime.name             | Java(TM) SE Runtime Environment
  sun.boot.library.path         | /home/apps/jdk1.6.0_21/jre/lib/i386
  java.vm.version               | 17.0-b16
  java.vm.vendor                | Sun Microsystems Inc.
  java.vendor.url               | http://java.sun.com/
  path.separator                | :
  java.vm.name                  | Java HotSpot(TM) Server VM
You need to ﬁnd the length of the longest key before you can print the table.] */
import collection.JavaConversions.propertiesAsScalaMap
val environment: mutable.Map[String, String] = System.getProperties
val maxVarLength = environment.keys.maxBy(_.size).size
// This seems a little clearer to me, but I don't know which would perform better
//val maxVarLength = environment.keys.map(_.size).max
// This doesn't seem that much better than maxBy, but returns the int instead of needing to do size on the result, yet not nearly as succinct
//val maxVarLength = environment.keys.foldLeft(0){(i, prop) => i max prop.size})
environment.foreach((pair) => println(s"%-${maxVarLength}s | %s".format(pair._1, pair._2)))

/*===================================================================*/
println(header.format(8))
/* 8: [Write a function minmax(values: Array[Int]) that returns a pair containing the
smallest and largest values in the array.] */
def minmax(values: Array[Int]): (Int, Int) = {
  (values.min, values.max)
}
val ints8 = Array(1,2,3,4,5,6,7,8,9,10,15,12)
println(minmax(ints8))

/*===================================================================*/
println(header.format(9))
/* 9: [Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
the counts of values less than v, equal to v, and greater than v.] */
def lteqgt(values: Array[Int], v: Int): (Array[Int], Array[Int], Array[Int]) = {
  (values.filter(_ < v), values.filter(_ == v), values.filter(_ > v))
}
val ints9 = Array(1,100,-99, 10, -9, 24, 19, 8)
val (lt1, eq1, gt1) = lteqgt(ints9, 1)
println("v=1: lt" + lt1.mkString("<",",",">") + " eq" + eq1.mkString("<",",",">") + " gt" + gt1.mkString("<",",",">"))
val (lt2, eq2, gt2) = lteqgt(ints9, 23)
println("v=23: lt" + lt2.mkString("<",",",">") + " eq" + eq2.mkString("<",",",">") + " gt" + gt2.mkString("<",",",">"))

/*===================================================================*/
println(header.format(10))
/* 10: [What happens when you zip together two strings, such as "Hello".zip("World")?
Come up with a plausible use case.] */
println("Hello".zip("World"))
println("You get a vector of pairs. The pairs are of two letters from the same position in each word.")
println("Plausible use case?")