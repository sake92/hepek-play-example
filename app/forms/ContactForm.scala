package forms

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints
import java.time.LocalDate

object ContactForm {

  val form = Form(
    mapping(
      "email"             -> text.verifying(Constraints.emailAddress),
      "password"          -> nonEmptyText, // picked up by Hepek, adds HTML5 validation! :)
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
