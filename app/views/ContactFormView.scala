package views

import play.api.data.Form
import play.api.mvc.Request
import play.filters.csrf.CSRF

import scalatags.Text.all.{form => _, _}
import forms.ContactForm
import util.Imports._, classes._, grid._
import hf._                           // hf is HepekForm
import fc.{formFieldset, inputSubmit} // fc is short for FormComponents

case class ContactFormView(
    contactForm: Form[ContactForm.Data],
    contactFormValues: Option[ContactForm.Data] = None
)(
    implicit request: Request[_],
    messages: play.api.i18n.Messages
) extends util.MainTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Contact form")

  override def pageContent = row(
    h2("Contact form"),
    formFrag,
    contactFormValues.map { values =>
      Panel.panel(
        panelType = Panel.Type.Success,
        body = values.toString,
        header = Some("Successfully submited form!")
      )
    }
  )

  def formFrag =
    form()(controllers.routes.HomeController.createForm)(
      formFieldset("Contact data")(
        inputEmail()(contactForm("email"), help = "Please enter your email"),
        inputPassword(required)(contactForm("password")),
        inputDate()(contactForm("dob"), label = "Date of birth")
      ),
      formFieldset("Preferences")(
        inputRadio(
          contactForm("favoriteSuperHero"),
          Seq(("batman", "Batman", Nil), ("superman", "Superman", Nil)),
          label = "Super hero",
          checkedValue = "superman",
          isInline = false
        ),
        inputSelectGrouped(multiple)(
          contactForm("animals[]"),
          Seq(
            "Cats" -> Seq(
              ("bengal", "Bengal", Nil),
              ("persian", "Persian", Seq(selected))
            ),
            "Dogs" -> Seq(
              ("goldenRetriever", "Golden retriever", Seq(selected)),
              ("husky", "Husky", Nil)
            )
          ),
          label = "Animals (multi-select)"
        )
      ), { // TODO make helper
        val maybeToken = CSRF.getToken
        maybeToken.map(token => fc.inputHidden(value := token.value)(token.name))
      },
      inputSubmit(btnPrimary)("Submit")
    )
}
