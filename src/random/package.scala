/*
  3: Write a package random with functions nextInt(): Int, nextDouble(): Double, and setSeed(seed: Int): Unit.
  To generate random numbers, use the linear congruential generator
      next = previous * a + b mod 2^n
  where a = 1664525, b = 1013904223, and n = 32.
*/
package object random {
  val a = 1664525
  val b = 1013904223
  val n = 32
  var previous = 0.0
  def nextInt(): Int = {
    nextDouble().toInt
  }

  def nextDouble(): Double = {
    this.previous *= a + b % math.pow(2, n)
    this.previous
  }

  def setSeed(seed: Int): Unit = {
    this.previous = seed
  }
}
