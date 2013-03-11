val header = "=" * 10 + "Chapter 6: Exercise %1$02d" + "=" * 10

/*===================================================================*/
println(header.format(1))
/* 1: [Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.] */

{
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

{
  import chapter6._

  println(InchesToCentimeters.convert(10))
  println(GallonsToLiters.convert(10))
  println(MilesToKilometers.convert(10))
}

/*===================================================================*/
println(header.format(3))
/* 3: [Define an Origin object that extends java.awt.Point. Why is this not actually a
good idea? (Have a close look at the methods of the Point class.)] */

{
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

/*===================================================================*/
println(header.format(5))

/*===================================================================*/
println(header.format(6))

/*===================================================================*/
println(header.format(7))

/*===================================================================*/
println(header.format(8))

/*===================================================================*/
println(header.format(9))

/*===================================================================*/
println(header.format(10))
