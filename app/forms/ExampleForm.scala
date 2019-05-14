package forms

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints

case class ExampleForm(email: String, password: String)

object ExampleForm {

  val form = Form[ExampleForm](
    mapping(
      "email"    -> nonEmptyText.verifying(Constraints.emailAddress),
      "password" -> nonEmptyText
    )(ExampleForm.apply)(ExampleForm.unapply)
  )
}
