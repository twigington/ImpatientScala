package chapter8

/*
  1: Extend the following BankAccount class to a CheckingAccount class that charges $1
  for every deposit and withdrawal.
*/
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double) = { super.deposit(amount - 1) }
  override def withdraw(amount: Double) = { super.withdraw(amount + 1) }
}
