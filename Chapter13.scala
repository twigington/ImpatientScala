import scala.collection._

// Chapter 13

// Exercise 1
// Write a function that, given a string, produces a map of the indexes of all characters.
// For example, indexes("Mississippi") should return a map associated 'M' with the set {0},
// 'i' with the set {1,4,7,10}, and so on. Use a mutable map of characters to mutable sets.
// How can you ensure that the set is sorted?
def indexes(str: String) = {
  var charMap: mutable.Map[Char, mutable.Set[Int]] = mutable.Map()
  for ((letter, idx) <- str.zipWithIndex) {
    if (charMap.contains(letter)) {
      charMap(letter) += idx
    } else {
      charMap += (letter -> mutable.SortedSet(idx))
    }
  }
  charMap
}

def printIndexes(str: String) = {
  println("\"" + str + "\" index breakdown")
  indexes(str).foreach { case (key, value) =>
    println("\t'" + key + "' indexes " + value.mkString("[",",","]"))
  }
}

printIndexes("Mississippi")
printIndexes("Wonderland")
printIndexes("Oz the Great & Powerful")

