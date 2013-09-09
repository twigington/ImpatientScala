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

  A: It means anything in the com package would have access to call the function.
*/