package chapter8.exercise9

/**
9. In the Creature class of Section 8.10, "Construction Order and Early Definitions", on page 92, replace val range
with a def.
    What happens when you also use a def in the Ant subclass?
    What happens when you use a val in the subclass?
    Why?
 */
class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}