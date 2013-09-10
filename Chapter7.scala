/* 1: [Write an example program to demonstrate that
            package com.horstmann.impatient
    is not the same as
            package com
            package horstmann
            package impatient]
*/
// See src/chapter7/exercise1*

/*
  2: Write a puzzler that baffles your Scala friends, using a package com that isn't at the top level.
*/

/*
  3: Write a package random with functions nextInt(): Int, nextDouble(): Double, and setSeed(seed: Int): Unit.
  To generate random numbers, use the linear congruential generator
      next = previous * a + b mod 2^n
  where a = 1664525, b = 1013904223, and n = 32.
*/
random.setSeed(1)
println(random.nextInt())
println(random.nextInt())
println(random.nextInt())
println(random.nextDouble())
println(random.nextDouble())
println(random.nextDouble())

/*
  4: Why do you think the Scala language designers provided the package object syntax instead of simply
  letting you add functions and variables to a package?

  A: It is a limit of the JVM which prevented them from doing so.
*/

/*
  5: What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?

  A: It means anything in the com package would have access to call the function. It allows you to create things that
  are only-package usable and not overridable with a sub-class
*/

/*
  6: Write a program that copies all elements from a Java hash map into a Scala has map. Use imports to rename both classes.
*/
new chapter7.Exercise6().run()

/*
  7: In the preceding exercise, move all imports into the innermost scope possible.
*/
new chapter7.Exercise7().run()

/*
  8: What is the effect of
      import java._
      import javax._
  Is this a good ida?
*/
// You could then skip "java.util.Collection". There are package overlaps between the two domains making this a bad idea.
// For example "lang" is a sub-package of both java and javax, so there is a collision and you'd end up still needing to
// specify. Also java._ is already included by default and then partially overridden by the scala._ auto-import.

/*
*/