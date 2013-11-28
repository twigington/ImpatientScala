package chapter8.exercise2

import chapter8.exercise1.BankAccount


/*
2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest
  every month (when a method earnMonthlyInterest is called) and has three free deposits or withdrawals every
  month. Reset the transaction count in the earnMonthlyInterest method.
 */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  val interest: Double = 0.02
  val transactionFee: Double = 1.0
  val freeTransactions: Int = 3
  var transactionCount: Int = 0
  def earnMonthlyInterest() = {
    transactionCount = 0
    super.deposit(super.deposit(0) * interest)
  }
  private def chargeTransaction() = {
    if (transactionCount < freeTransactions) transactionCount += 1
    else super.withdraw(transactionFee)
  }
  override def deposit(amount: Double) = {
    chargeTransaction()
    super.deposit(amount)
  }
  override def withdraw(amount: Double) = {
    chargeTransaction()
    super.withdraw(amount)
  }
}
