package model

case class Hero(name: String):
  def key = name.toLowerCase.replace(" ", "-")

object Hero:
  val All = List(Hero("Batman"), Hero("Superman"))

////////////////////////
case class Animal(name: String):
  def key = name.toLowerCase.replace(" ", "-")

object Animal:
  val All = List(
    Animal("Golden retriever"),
    Animal("Husky"),
    Animal("Bengal"),
    Animal("Persian")
  )
