package views

import play.api.data.Form
import scalatags.Text.all._
import forms.ExampleForm
import util._, Imports._

case class ExampleFormView(
    form: Form[ExampleForm],
    success: Boolean = false
)(
    implicit messages: play.api.i18n.Messages
) extends MainTemplate {

  override def pageSettings = super.pageSettings.withTitle("IndexForm")

  // hf is short for HepekForm
  override def pageContent: Frag = div(
    hf.form()(controllers.routes.HomeController.createForm)(
      hf.inputText()(
        form("email"),
        help = "Please enter your email"
      ),
      hf.inputPassword(required)(form("password")),
      hf.fc.inputSubmit()("Submitni") // low-level, raw API
    ),
    if (!success) frag()
    else p(cls := "bg-success")("Successfully submited form!")
  )
}
