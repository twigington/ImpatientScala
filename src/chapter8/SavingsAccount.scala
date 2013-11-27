package chapter8

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  val freeTransactions: Int = 3
  var transactionCount: Int = 0
  //def earnMonthlyInterest() = { balance }
}
