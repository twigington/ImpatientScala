package chapter6

object CardSuit extends Enumeration {
  type CardSuit = Value
  val Spades = Value("\u2660")
  val Hearts = Value("\u2665")
  val Diamonds = Value("\u2666")
  val Clubs = Value("\u2663")
}
