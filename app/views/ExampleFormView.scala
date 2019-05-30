package views

import play.api.data.Form
import scalatags.Text.all.{form => _, _}
import forms.ExampleForm
import util.Imports._
import grid._
import hf._      // hf is HepekForm
import classes._ // utility classes

case class ExampleFormView(
    exampleForm: Form[ExampleForm],
    exampleFormValues: Option[ExampleForm] = None
)(
    implicit messages: play.api.i18n.Messages
) extends util.MainTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Example form")

  override def pageContent = div(
    h1("Example form"),
    row(third(), third(formFrag), third()),
    exampleFormValues.map { values =>
      p(bgSuccess)(
        """
          **Successfully submited form!**  
          Values:
        """.md,
        values.toString
      )
    }
  )

  // fc is short for FormComponents
  def formFrag =
    form()(controllers.routes.HomeController.createForm)(
      fc.formFieldset("Contact data")(
        inputEmail()(exampleForm("email"), help = "Please enter your email"),
        inputPassword(required)(exampleForm("password")),
        inputDate()(exampleForm("dob"), label = "Date of birth")
      ),
      fc.formFieldset("Preferences")(
        inputRadio(
          exampleForm("favoriteSuperHero"),
          Seq(("batman", "Batman", Nil), ("superman", "Superman", Nil)),
          label = "Super hero",
          checkedValue = "superman",
          isInline = false
        ),
        inputSelectGrouped(multiple)(
          exampleForm("animals[]"),
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
      ),
      fc.inputSubmit()("Submit") // low-level, raw API
    )
}
