val header = "=" * 10 + "Chapter 2: Exercise %1$02d" + "=" * 10

/*===============================================*/
println(header.format(1))
def mySignum(x: Int) = { if (x > 0) 1 else if (x < 0) -1 else 0 }

println("mySignum(-100)=" + mySignum(-100))
println("mySignum(-1)=" + mySignum(-1))
println("mySignum(0)=" + mySignum(0))
println("mySignum(1)=" + mySignum(1))
println("mySignum(100)=" + mySignum(100))

/*===============================================*/
println(header.format(2))
println("What is the value of {}?")
val a = {}
println(a)
println(a.getClass)
println("value is (), type is Unit")

/*===============================================*/
println(header.format(3))
println("If x is of the type Unit you can execute x = y = 1. But I don't think it accomplishes anything useful.")

var x: Unit = ()
var y: Int = 0
println("Before: x=" + x + ",y=" + y)
x = y = 1
println("After: x=" + x + ",y=" + y)

/*===============================================*/
println(header.format(4))
println("Using foreach")
10 to 0 by -1 foreach println
println("Alt 1: for using reverse")
for (x <- (0 to 10).reverse) println(x)
println("Alt 2: for using by -1")
for (x <- 10 to 0 by -1) println(x)

/*===============================================*/
println(header.format(5))
def countdown(n: Int) { n to 0 by -1 foreach println }

countdown(15)

/*===============================================*/
println(header.format(6))
var sum: Long = 1
for (ch <- "Hello") sum *= ch.toLong
println(sum)

/*===============================================*/
println(header.format(7))
// parallel fold example?

print("Map/Product: ")
println("Hello".map{_.toLong}.product)

print("Map/Reduce (parallel?): ")
println("Hello".map{_.toLong}.reduce{_ * _})

print("Map/ReduceLeft:")
println("Hello".map{_.toLong}.reduceLeft{ _ * _ })

print("Fold Left example:")
println("Hello".foldLeft(1L) { _ * _.toLong })

print("For each with a closure around the sum variable:")
sum = 1
for (ch <- "Hello") sum *= ch.toLong
println(sum)

/*===============================================*/
println(header.format(8))
def product(s: String) = { s.map{_.toLong}.product }

println(product("MonkeyFarts"))

println(product("Hello"))

/*===============================================*/
println(header.format(9))
def productRecursive(s: String):Long = { if (s.tail.length > 0) s.head.toLong * productRecursive(s.tail) else s.head.toLong }

println(productRecursive("Hello"))

// Alternative (I think I like my first one better)
def productRecursive2(s: String):Long = { s.head * (if (s.tail.length == 0) 1 else productRecursive2(s.tail)) }
println(productRecursive2("Hello"))

/*===============================================*/
println(header.format(10))
def func(x: Double, n: Int): Double = {
  if(n > 0) {
    if(n % 2 == 0)
      math.pow(func(x, n/2),2)
    else
      x*func(x, n-1)
  } else if(n < 0)
    1 / func(x, -n)
  else 1
}

println(func(0, 0))
println(func(1, 0))
println(func(0, 1))
println(func(1, 1))
println(func(2, 1))
println(func(1, 2))
println(func(2, 2))
println(func(10, 2))
println(func(2, 10))
println(func(2, -1))
println(func(2, -2))