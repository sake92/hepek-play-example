package views

import play.api.data.{Form => PlayForm}
import play.api.mvc.Request
import play.api.i18n.Messages
import play.filters.HttpFiltersComponents

import models.*
import PlayBundle.*, Bundle.*, Tags.*

class CreateCustomerView(playForm: PlayForm[CreateCustomer.Data])(using
    request: Request[?],
    messages: Messages
) extends MainTemplate {

  private val formData = playForm.value

  override def pageSettings =
    super.pageSettings.withTitle("Customer form")

  override def pageContent = Grid.row(
    h2("Customer form"),
    formData.map { values =>
      Panel.panel(
        panelType = Panel.Companion.Type.Success,
        header = Some("Successfully submitted form!"),
        body = "Data received: " + values.toString
      )
    },
    formFrag
  )

  def formFrag =
    PF.form()(controllers.routes.HomeController.submitForm())(
      Form.formFieldset("Customer data:")(
        PF.inputEmail()(playForm("email"), label = "Email"),
        PF.inputPassword()(playForm("password"), label = "Password"),
        PF.inputDate()(playForm("dob"), label = "Date of birth")
      ),
      Form.formFieldset("Preferences:")(
        PF.inputRadio(
          playForm("favoriteSuperHero"),
          Hero.All.map(h => (h.key, h.name, Nil)),
          label = "Super hero",
          checkedValue = Hero.All.head.key,
          isInline = false
        ),
        PF.inputSelect(multiple, size := "6")(
          playForm("animals[]"),
          Animal.All.map { animal =>
            (animal.key, animal.name, Nil)
          },
          label = "Animals (multi-select)"
        )
      ),
      Form.inputSubmit(Classes.btnPrimary)("Submit")
    )
}
