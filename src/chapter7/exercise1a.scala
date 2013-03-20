/* 1: [Write an example program to demonstrate that
            package com.horstmann.impatient
    is not the same as
            package com
            package horstmann
            package impatient]
*/
/* I am not sure, what the exercise is asking. Is it talking about Top-of-File Notation or Nested? */

// I think Top-of-File, but here is an example of what Nested syntax answer might be.
// See a-file and b-file for Top-of-File Notation answer.

package com.babelfeesh {
  class Coconut
}

package com {
  package babelfeesh {
    package impatient {
      class Banana

      // using the nested syntax the Human class can access both Coconut and Banana. Higher level package objects/classes are in scope.
      class Human {
        def eat(coconut: Coconut) { println("Human eats coconut: " + coconut.toString) } // this won't compile
        def eat(banana: Banana) { println("Human eats Banana: " + banana.toString) }
      }
    }
  }
}

package com.babelfeesh.impatient {
  class Monkey {
    // Monkey cannot access Coconut without an import because the chained package clause does not imply scope to higher level packages.
    import com.babelfeesh.Coconut
    def eat(coconut: Coconut) { println("Monkey eats coconut: " + coconut.toString) } // this won't compile without the import
    // Monkey can access Banana since they are in the same package.
    def eat(banana: Banana) { println("Monkey eats Banana: " + banana.toString) }
  }
}

