package chapter8.exercise9

/**
9. In the Creature class of Section 8.10, "Construction Order and Early Definitions", on page 92, replace val range
with a def.
    What happens when you also use a def in the Ant subclass?
        A: Things work as expected. now that range is a function in both classes the constructor of the parent
        class will call the overridden method of the child class and env will be initialized with 2 elements.
    What happens when you use a val in the subclass?
        A: When using a def in the superclass and a value in the subclass env is still initialized with zero elements
        because the subclass variable is still an uninitialized zero and the superclass constructor appears to use
        the value defined in the subclass before trying to use a function from itself.
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
