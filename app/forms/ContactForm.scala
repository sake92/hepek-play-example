package forms

import java.time.LocalDate
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints

object ContactForm {

  val form = Form(
    mapping(
      "email"             -> text.verifying(Constraints.emailAddress),
      "password"          -> nonEmptyText, // picked up by Hepek, adds HTML5 validation automatically! :)
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
  object Data {
    def unapply(data: Data): Option[(String, String, LocalDate, String, List[String])] =
      Some((data.email, data.password, data.dob, data.favoriteSuperHero, data.animals))
  }
}
