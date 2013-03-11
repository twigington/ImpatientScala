package chapter6

abstract class UnitConversion {
  def convert(value: Double): Double
}

object InchesToCentimeters extends UnitConversion {
  def convert(inches: Double) = {inches * 2.54}
}

object GallonsToLiters extends UnitConversion {
  def convert(gallons: Double) = {gallons * 3.78541}
}

object MilesToKilometers extends UnitConversion {
  def convert(miles: Double) = {miles * 1.60934}
}
