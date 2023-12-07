package models

case class Animal(name: String):
  def key = name.toLowerCase.replace(" ", "-")

object Animal:
  val All = List(
    Animal("Golden retriever"),
    Animal("Husky"),
    Animal("Bengal"),
    Animal("Persian")
  )
