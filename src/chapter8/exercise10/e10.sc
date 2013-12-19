/*
10. scala/collections/immutable/Stack.scala contains the definition:
      class Stack[A] protected {protected val elems: List[A]}
Explain the meanings of the protected keywords. (Hint Review the discussion of private constructors in Chapter 5.)

A: The protected elems marks the elems attribute as only assessable to sub-classes.
  Interestingly enough the getter "color()" is actually public if you decompile
  the class file with javap. But it would appear that the scala compiler prevents
  this type of access.

  The protected constructor (the "protected" between class name and primary
  constructor) means that you cannot construct the class from anywhere else.
  The decompiled java of the scala class leaves the class and constructors
  public, so it would appear this behavior is enforced purely by the scala
  compiler. You can subclass the class with a protected constructor all you want
  and from other packages.
*/
class Shape(protected val color: String)
class Circle(color: String) extends Shape(color) {
  override def toString() = {
    s"Circle(color=${color})"
  }
}

val circle = new Circle("red")
println(circle)
println(circle.color) // this doesn't work





class Animal protected (protected val name: String) {
  override def toString = s"${this.getClass.getSimpleName}(name=$name)"
}
class Dog(name: String) extends Animal(name)

val animal = new Animal("Tiger")






val dog = new Dog("Spot")










































class SomethingElse {
  def buildShape = new Animal("Mia")
}












