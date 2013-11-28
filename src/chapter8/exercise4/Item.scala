package chapter8.exercise4

/**
4. Define an abstract class Item with methods price and description. A SimpleItem is an item whose price and
description are specified in the constructor. Take advantage of the fact that val can override a def. A Bundle
is an item the contains other items. Its price is the sum of the prices in the bundle. Also provide a mechanism
for adding items to the bundle and a suitable description method.
*/
abstract class Item {
  def price(): Double
  def description(): String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle(val description: String) extends Item {
  private val items: List[Item] = List.empty
  def addItem(item: Item): Unit = {
    item :: items
  }

  override def price(): Double = {
    items.foldRight(0.0) { (item, acc) =>
      acc + item.price
    }
  }
}