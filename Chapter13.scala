// Chapter 13

// Exercise 1
// Write a function that, given a string, produces a map of the indexes of all characters.
// For example, indexes("Mississippi") should return a map associated 'M' with the set {0},
// 'i' with the set {1,4,7,10}, and so on. Use a mutable map of characters to mutable sets.
// How can you ensure that the set is sorted?
def indexes(str: String) = {
  var charMap = scala.collection.mutable.Map[Char, Set[Int]]
  for ((letter, idx) <- str.zipWithIndex) {
    charMap
  }
}

val str = "Mississippi"
println(str)
println(str.reverse)
println(str.distinct)
//println(str.distinct.map {letter: Char => letter + "2"})
import scala.collection._
var charMap: mutable.Map[Char, mutable.Set[Int]] = mutable.Map()
for ((letter, idx) <- str.zipWithIndex) {
  //charMap += (letter, mutable.Set(idx))
}