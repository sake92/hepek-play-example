package views

import play.api.data.Form
import play.api.mvc.Request
import play.api.i18n.Messages

import scalatags.Text.all.{form => _, _}
import forms.ContactForm
import util.Imports._, Classes._, grid._
import hf._                           // hf is HepekForm
import fc.{formFieldset, inputSubmit} // fc is FormComponents

case class ContactFormView(
    contactForm: Form[ContactForm.Data],
    contactFormValues: Option[ContactForm.Data] = None
)(
    implicit request: Request[_],
    messages: Messages
) extends util.MainTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Contact form")

  override def pageContent = row(
    h2("Contact form"),
    
    contactFormValues.map { values =>
      Panel.panel(
        panelType = Panel.Companion.Type.Success,
        body = "Data received: " + values.toString,
        header = Some("Successfully submitted form!")
      )
    },
    formFrag
  )

  def formFrag =
    form()(controllers.routes.HomeController.createForm)(
      formFieldset("Contact data:")(
        inputEmail()(contactForm("email"), label = "Email"),
        inputPassword()(contactForm("password"), label = "Password"),
        inputDate()(contactForm("dob"), label = "Date of birth")
      ),
      formFieldset("Preferences:")(
        inputRadio(
          contactForm("favoriteSuperHero"),
          model.Hero.All.map(h => (h.key, h.name, Nil)),
          label = "Super hero",
          checkedValue = model.Hero.Superman.key,
          isInline = false
        ),
        inputSelectGrouped(multiple, size := "6")(
          contactForm("animals[]"),
          model.Animal.All.map {
            case (tpe, animals) =>
              tpe -> animals.map(h => (h.key, h.name, Nil))
          }.toList,
          label = "Animals (multi-select)"
        )
      ),
      inputSubmit(btnPrimary)("Submit")
    )
}
