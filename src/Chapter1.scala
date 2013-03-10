val header = "=" * 10 + "Chapter 1: Exercise %1$02d" + "=" * 10

/* Exercise 2
scala> sqrt(3)
res63: Double = 1.7320508075688772

scala> pow(res63,2)
res64: Double = 2.9999999999999996
 */

/* Exercise 3: val */

/* Exercise 4:
scala> "crazy" * 3
res65: String = crazycrazycrazy
 */

/* Exercise 5:
10 max 2 is the same as 10.max(2) and means return the max value between 10 and 2. thus the answer is 10.

max is declared on Int (technically RichInt)
 */

/* Exercise 6:
scala> BigInt(2) pow 1024
res67: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
 */

println(header.format(7))
import BigInt._
import util.Random

println(probablePrime(100,Random))

/* Exercise 8
scala> probablePrime(100,Random) toString 36
res1: String = 2uegceqg816nfo5tdunz
 */
println(header.format(8))
println(probablePrime(100,Random) toString 36)

/* Exercise 9: There are more ways than these two... */
println(header.format(9))
println("abcdef" take 1)
println("abcdef" takeRight 1)

/* Exercise 10:
  The advantages:
    * more succinct (Less typing)
    * more expressive (Easier to read and tell what they are doing)
  The disadvantages:
    * There are more methods to write/maintain/document/know.
          (Or are there...? I believe these are common methods that a lot of objects share in functional oo languages.)
 */
println(header.format(10))
println("abcdef" take 2)
println("abcdef".substring(0, 2))

println("abcdef" takeRight 2)
println("abcdef".substring("abcdef".length - 2, "abcdef".length))

println("abcdef" drop 2)
println("abcdef".substring(2, "abcdef".length))

println("abcdef" dropRight 2)
println("abcdef".substring(0, 4))
