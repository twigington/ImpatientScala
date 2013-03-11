val header = "=" * 10 + "Chapter 5: Exercise %1$02d" + "=" * 10

/*===================================================================*/
println(header.format(1))
/* 1: [Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
Methods, Why No Multiple Inheritance?,” on page 49 so that it doesn't turn
negative at Int.MaxValue.] */
class Counter {
  private var value = Int.MaxValue - 2 // You /must/ initialize the field
  def increment() { if(value < Int.MaxValue) value += 1 }
  def current() = value
}

val aCounter = new Counter
println("Int.MaxValue=" + Int.MaxValue)
println("Counter=" + aCounter.current())
aCounter.increment()
println("Counter=" + aCounter.current())
aCounter.increment()
println("Counter=" + aCounter.current())
aCounter.increment()
println("Counter=" + aCounter.current())
aCounter.increment()
println("Counter=" + aCounter.current())

/*===================================================================*/
println(header.format(2))
/* 2: [Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.] */
class BankAccount(private var _balance : BigDecimal = BigDecimal.valueOf(0)) {
  def deposit(amount : BigDecimal) { _balance += amount}
  def withdraw(amount : BigDecimal) { _balance -= amount}
  def balance = _balance
}

val myAccount = new BankAccount
println("Initial Balance=" + myAccount.balance)
myAccount.deposit(BigDecimal.valueOf(2000))
println("Deposit 2000=" + myAccount.balance)
myAccount.withdraw(BigDecimal.valueOf(50))
println("Withdraw 50=" + myAccount.balance)

/*===================================================================*/
println(header.format(3))
/* 3: [Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean
that checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min),
where hrs is in military time format (between 0 and 23).] */
class TimeE3 (private var _hours:Int = 0, private var _minutes:Int = 0) {
  if (_hours < 0) _hours = 0
  if (_hours > 23) _hours = 23
  if (_minutes < 0) _minutes = 0
  if (_minutes > 59) _minutes = 59

  def hours = _hours
  def minutes = _minutes
  def before(other: TimeE3): Boolean = {
    if (this.hours < other.hours) { true }
    else if (this.hours == other.hours && this.minutes < other.minutes) { true }
    else false
  }
}

val time1 = new TimeE3(1,10)
val time2 = new TimeE3(22,20)
val time3 = new TimeE3(1,30)
println("time1.before(time2)" + time1.before(time2))
println("time2.before(time1)" + time2.before(time1))
println("time3.before(time1)" + time3.before(time1))
println("time1.before(time3)" + time1.before(time3))
val time4 = new TimeE3(25,67)
println("time4=" + time4.hours + ":" + time4.minutes)

/*===================================================================*/
println(header.format(4))
/* 4: [Re-implement the Time class from the preceding exercise so that the internal representation is the number
 of minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public interface. That is, client code
  should be unaffected by your change.] */
class TimeE4 (_hours:Int = 0, _minutes:Int = 0) {
  private val minutesInDay : Int = {_hours.min(23) * 60 + _minutes.min(59)}

  def hours = {minutesInDay / 60}
  def minutes = {minutesInDay % 60}
  def before(other: TimeE4): Boolean = {
    if (this.minutesInDay < other.minutesInDay) { true }
    else false
  }
}

val time1E4 = new TimeE4(1,10)
val time2E4 = new TimeE4(22,20)
val time3E4 = new TimeE4(1,30)
println("time1(1,10)=" + time1E4.hours + ":" + time1E4.minutes)
println("time2(22,20)=" + time2E4.hours + ":" + time2E4.minutes)
println("time1.before(time2)" + time1E4.before(time2E4))
println("time2.before(time1)" + time2E4.before(time1E4))
println("time3.before(time1)" + time3E4.before(time1E4))
println("time1.before(time3)" + time1E4.before(time3E4))
val time4E4 = new TimeE4(25,67)
println("time4(25,67)=" + time4E4.hours + ":" + time4E4.minutes)

/*===================================================================*/
println(header.format(5))
/* 5: [Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long).
  What methods are generated? (Use javap to check.)
  Can you call the JavaBeans getters and setters in Scala? Should you?] */
import chapter5.Student

val tom = new Student("Tom", 1)
println("getId=" + tom.getId + " getName=" + tom.getName)
println("id=" + tom.id + " name=" + tom.name)
println(tom)
/* results of compilation
class Student(@scala.beans.BeanProperty val name : scala.Predef.String, @scala.beans.BeanProperty val id : scala.Long) extends java.lang.Object {
  def getName() : scala.Predef.String = { /* compiled code */ }
  def setName(x$1 : scala.Predef.String) : scala.Unit = { /* compiled code */ }
  def getId() : scala.Long = { /* compiled code */ }
  def setId(x$1 : scala.Long) : scala.Unit = { /* compiled code */ }
}
 */
// You can access the generated getters and setters from Scala. You can also use the scala-esque methods, so not much reason to.

/*===================================================================*/
println(header.format(6))
/* 6: [In the Person class of Section 5.1, “Simple Classes and Parameterless Methods Why No Multiple Inheritance?,”
on page 49, provide a primary constructor that turns negative ages to 0.] */
class Person(var age: Int) {
  if (age < 0) age = 0
}

println("Age " + new Person(-10).age)
println("Age " + new Person(12).age)

/*===================================================================*/
println(header.format(7))
/* 7: [Write a class Person with a primary constructor that accepts a string containing a first name, a space,
  and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName.
  Should the primary constructor parameter be a var, a val, or a plain parameter? Why?] */
import chapter5.PersonE7

val fake = new PersonE7("Fake Name")
println("FN=" + fake.firstName + ", LN=" + fake.lastName)

// I made the primary constructor parameter a plain parameter
// because I don't want to store the full name to keep it DRY.

/*===================================================================*/
println(header.format(8))
/* 8: [Make a class Car with read-only properties for manufacturer, model name,
and model year, and a read-write property for the license plate. Supply four
constructors. All require the manufacturer and model name. Optionally,
model year and license plate can also be specified in the constructor. If not,
the model year is set to -1 and the license plate to the empty string. Which
constructor are you choosing as the primary constructor? Why?] */
import chapter5.Car

val car1 = new Car("Ford", "Mustang", 1979, "MO12345")
println("1 Make:" + car1.manufacturer + ", Model:" + car1.modelName + ", Year:" + car1.modelYear + ", Lic#:" + car1.licensePlate)

val car2 = new Car("Toyota", "Prius", "MOABCD")
println("2 Make:" + car2.manufacturer + ", Model:" + car2.modelName + ", Year:" + car2.modelYear + ", Lic#:" + car2.licensePlate)

val car3 = new Car("Chevy", "Avalanche")
println("3 Make:" + car3.manufacturer + ", Model:" + car3.modelName + ", Year:" + car3.modelYear + ", Lic#:" + car3.licensePlate)

val car4 = new Car("Dodge", "Charger", 1990)
println("4 Make:" + car4.manufacturer + ", Model:" + car4.modelName + ", Year:" + car4.modelYear + ", Lic#:" + car4.licensePlate)

// I made the default constructor the broadest, the one with all parameters, and used default values on
// the two optional parameters. I did this because this covers 3 out of 4 constructors. I only need to
// create the 4th for when the model year is not provided, but license plate number is.

/*===================================================================*/
println(header.format(9))
/* 9: [Re-implement the class of the preceding exercise in Java, C#, or C++ (your choice).
  How much shorter is the Scala class?] */
import chapter5.JavaCar

val jcar1 = new JavaCar("Ford", "Mustang", 1979, "MO12345")
println("1 Make:" + jcar1.getManufacturer + ", Model:" + jcar1.getModelName + ", Year:" + jcar1.getModelYear + ", Lic#:" + jcar1.getLicensePlate)

val jcar2 = new JavaCar("Toyota", "Prius", "MOABCD")
println("2 Make:" + jcar2.getManufacturer + ", Model:" + jcar2.getModelName + ", Year:" + jcar2.getModelYear + ", Lic#:" + jcar2.getLicensePlate)

val jcar3 = new JavaCar("Chevy", "Avalanche")
println("3 Make:" + jcar3.getManufacturer + ", Model:" + jcar3.getModelName + ", Year:" + jcar3.getModelYear + ", Lic#:" + jcar3.getLicensePlate)

val jcar4 = new JavaCar("Dodge", "Charger", 1990)
println("4 Make:" + jcar4.getManufacturer + ", Model:" + jcar4.getModelName + ", Year:" + jcar4.getModelYear + ", Lic#:" + jcar4.getLicensePlate)

// 5 lines of scala 41 lines of java

/*===================================================================*/
println(header.format(10))
/* 10: [Consider the class
class Employee(val name: String, var salary: Double) {
  def this() { this("John Q. Public", 0.0) }
}
Rewrite it to use explicit fields and a default primary constructor. Which form
do you prefer? Why?] */

class Employee {
  private[this] var _name: String = "John Q. Public"
  var salary: Double = 0.0

  def this(name: String, salary: Double) {
    this
    this._name = name
    this.salary = salary
  }

  def name = _name
}

// with explicit fields and default primary constructor you have to make "name" a var instead of a val and hide the
// fact it is a var by restricting declaring it private (or event tighter with private[this]) and only providing a getter.
// it is also more verbose. So I'd prefer the first, but honestly what I prefer using default values like...
class Employee2(val name: String = "John Q. Public", var salary: Double = 0.0) {}

val john = new Employee2()
val steve = new Employee2("Steve McQueen", 100)
steve.salary = 200 // give steve a raise!
println(steve.name + " makes " + steve.salary)
