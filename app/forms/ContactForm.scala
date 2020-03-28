package forms

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints
import java.time.LocalDate

object ContactForm {

  val form = Form(
    mapping(
      "email"             -> nonEmptyText.verifying(Constraints.emailAddress),
      "password"          -> text,
      "dob"               -> localDate,
      "favoriteSuperHero" -> text,
      "animals"           -> list(text)
    )(Data.apply)(Data.unapply)
  )

  case class Data(
      email: String,
      password: String,
      dob: LocalDate,
      favoriteSuperHero: String,
      animals: List[String]
  )
}
