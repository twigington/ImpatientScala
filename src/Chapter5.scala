import beans.BeanProperty

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
class Student(@BeanProperty var name : String, @BeanProperty var id : Long) {

}

/*===================================================================*/
println(header.format(6))

/*===================================================================*/
println(header.format(7))

/*===================================================================*/
println(header.format(8))

/*===================================================================*/
println(header.format(9))

/*===================================================================*/
println(header.format(10))

