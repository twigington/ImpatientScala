import chapter6.{CardSuit, ColorCube}

val header = "=" * 10 + "Chapter 6: Exercise %1$02d" + "=" * 10

/*===================================================================*/
println(header.format(1))
/* 1: [Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.] */
if (true) {
  import chapter6.Conversions

  println(Conversions.inchesToCentimeters(10))
  println(Conversions.gallonsToLiters(10))
  println(Conversions.milesToKilometers(10))
}

/*===================================================================*/
println(header.format(2))
/* 2: [The preceding problem wasn't very object-oriented. Provide a general super-
class UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and
MilesToKilometers that extend it.] */
if (true) {
  import chapter6._

  println(InchesToCentimeters.convert(10))
  println(GallonsToLiters.convert(10))
  println(MilesToKilometers.convert(10))
}

/*===================================================================*/
println(header.format(3))
/* 3: [Define an Origin object that extends java.awt.Point. Why is this not actually a
good idea? (Have a close look at the methods of the Point class.)] */
if (true) {
  import chapter6._

  Origin.x = 1
  Origin.y = 2

  println(Origin.toString)
}

// inheriting as an object makes it a singleton and Point is mutable and not tread-safe

/*===================================================================*/
println(header.format(4))
/* 4: [Define a Point class with a companion object so that you can construct Point
instances as Point(3, 4), without using new.] */
if (true) {
  import chapter6.Point

  val myPoint = Point(3,4)
  println(myPoint.x + "," + myPoint.y)
}

/*===================================================================*/
println(header.format(5))
/* 5: [Write a Scala application, using the App trait, that prints the command-line
  arguments in reverse order, separated by spaces. For example, scala Reverse
  Hello World should print World Hello.] */
println("See chapter6.Reverse")

/*===================================================================*/
println(header.format(6))
/* 6: [Write an enumeration describing the four playing card suits so that the toString method returns ♣, ♦, ♥, or ♠.] */
if (true) {
  import chapter6.CardSuit

  println("Spades = " + CardSuit.Spades)
  println("Hearts = " + CardSuit.Hearts)
  println("Diamonds = " + CardSuit.Diamonds)
  println("Clubs = " + CardSuit.Clubs)

  println(CardSuit.values.mkString("<",",",">"))
}

/*===================================================================*/
println(header.format(7))
/* 7: [Implement a function that checks whether a card suit value from the preceding exercise is red.] */
if (true) {
  import chapter6.CardSuit._

  def isRed(suit: CardSuit) = {
    suit == Diamonds || suit == Hearts
  }

  CardSuit.values.foreach(suit => println("isRed(" + suit + ")=" + isRed(suit)))

  //println("isRed(" + Spades + ") = " + isRed(Spades))
  //println("isRed(" + Hearts + ") = " + isRed(Hearts))
  //println("isRed(" + Diamonds + ") = " + isRed(Diamonds))
  //println("isRed(" + Clubs + ") = " + isRed(Clubs))
}

/*===================================================================*/
println(header.format(8))
/* 8: [Write an enumeration describing the eight corners of the RGB color cube.
  As IDs, use the color values (for example, 0xff0000 for Red).] */
if (true) {
  import chapter6.ColorCube._

  //for (color <- ColorCube.values) println(color.id + ": " + color)
  ColorCube.values.foreach(color => println(color.id + ": " + color))
}
