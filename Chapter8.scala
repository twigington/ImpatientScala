/*
Chapter 8
*/

/*
  1: Extend the following BankAccount class to a CheckingAccount class that charges $1
  for every deposit and withdrawal.
      class BankAccount(initialBalance: Double) {
        private var balance = initialBalance
        def deposit(amount: Double) = { balance += amount; balance }
        def withdraw(amount: Double) = { balance -= amount; balance }
      }
*/
