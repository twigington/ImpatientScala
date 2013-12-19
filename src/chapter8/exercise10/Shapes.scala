package chapter8.exercise10

class Shape(protected val color: String)
class Circle(color: String) extends Shape(color) {
  override def toString = s"Circle(color=${color})"
}

class SomethingElse(shape: Shape) {
  // this doesn't work.
  //def shapeColor = shape.color
}

class Animal protected (protected val name: String) {
  override def toString = s"${this.getClass.getSimpleName}(name=${name})"
}

class Dog(name: String) extends Animal(name)

class AnotherThing() {
  // can't do this. compile error.
  // def buildSpot = new Animal("Spot")
}