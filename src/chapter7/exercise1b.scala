/* 1: [Write an example program to demonstrate that
            package com.horstmann.impatient
    is not the same as
            package com
            package horstmann
            package impatient]
*/
/* Can package commands build on each other? it would appear that way. */

package com
package babelfeesh
package impatient

class TheClash {
  // no import needed since it appears higher level classes and objects
  // are implied as in-scope with this style of Top-of-File Notation.
  def break(coconut : Coconut) {println("The Clash breaks coconut: " + coconut.toString)}
  def peal(banana : Banana) {println("The Clash breaks banana: " + banana.toString)}
}
