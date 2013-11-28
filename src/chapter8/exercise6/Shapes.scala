package chapter8.exercise6

import chapter8.exercise5.Point

/**
6. Define an abstract Shape with an abstract method centerPoint and subclasses Rectangle and Circle. Provide
appropriate constructors for the subclasses and override the centerPoint method in each subclass.
 */
abstract class Shape {
  def centerPoint(): Point
}

class Rectangle(val upperLeft: Point, val width: Double, val height: Double) extends Shape {
  def centerPoint(): Point = {
    new Point(upperLeft.x + (width/2), upperLeft.y - (height/2))
  }
}

class Circle(val centerPoint: Point, val radius: Double) extends Shape