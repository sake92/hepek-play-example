package model

sealed abstract class Hero(val key: String, val name: String)

object Hero {
  case object Batman   extends Hero("batman", "Batman")
  case object Superman extends Hero("superman", "Superman")
  val All = List[Hero](Batman, Superman)
}

sealed abstract class Animal(val tpe: String) {
  def key: String
  def name: String
}

object Animal {

  case class Dog(val key: String, val name: String) extends Animal("Dog")
  case class Cat(val key: String, val name: String) extends Animal("Cat")

  val All: Map[String, List[Animal]] = List(
    Dog("goldenRetriever", "Golden retriever"),
    Dog("husky", "Husky"),
    Cat("bengal", "Bengal"),
    Cat("persian", "Persian")
  ).groupBy(_.tpe)
}
