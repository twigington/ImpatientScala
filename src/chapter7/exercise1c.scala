/* 1: [Write an example program to demonstrate that
            package com.horstmann.impatient
    is not the same as
            package com
            package horstmann
            package impatient]
*/
/* Can package commands build on each other? */

package com.babelfeesh.impatient

// class TheClash // won't compile. They are still the same package with either style.
class TheClash2 {
  // need the implicit import since higher level classes and objects are not in-scope using the chained notation.
  import com.babelfeesh.Coconut
  def break(coconut : Coconut) {println("The Clash breaks coconut: " + coconut.toString)}
  def peal(banana : Banana) {println("The Clash breaks banana: " + banana.toString)}
}
