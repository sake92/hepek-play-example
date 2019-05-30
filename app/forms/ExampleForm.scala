package forms

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints
import java.time.LocalDate

case class ExampleForm(
    email: String,
    password: String,
    dob: LocalDate,
    favoriteSuperHero: String,
    animals: List[String]
)

object ExampleForm {

  val form = Form[ExampleForm](
    mapping(
      "email"             -> nonEmptyText.verifying(Constraints.emailAddress),
      "password"          -> nonEmptyText,
      "dob"               -> localDate,
      "favoriteSuperHero" -> text,
      "animals"           -> list(text)
    )(ExampleForm.apply)(ExampleForm.unapply)
  )
}
