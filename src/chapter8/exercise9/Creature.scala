package chapter8.exercise9

/**
9. In the Creature class of Section 8.10, "Construction Order and Early Definitions", on page 92, replace val range
with a def.
    What happens when you also use a def in the Ant subclass?
        A: Things work as expected
    What happens when you use a val in the subclass?
        A: Compilation error that overriding value method needs to be stable, immutable value
    Why?
 */
class CreatureA {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class AntA extends CreatureA {
  override val range = 2
}

class CreatureB {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class AntB extends CreatureB {
  override val range = 2
}

class CreatureC {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class AntC extends CreatureC {
  override def range = 2
}

/* Results in compilation error
class CreatureD {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class AntD extends CreatureD {
  override def range = 2
}*/
