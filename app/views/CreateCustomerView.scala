package views

import play.api.data.{Form => PlayForm}
import play.api.mvc.Request
import play.api.i18n.Messages

import models.*
import PlayBundle.*, Bundle.*, Tags.*

class CreateCustomerView(
    contactForm: PlayForm[CreateCustomer.Data],
    contactFormValues: Option[CreateCustomer.Data] = None
)(using request: Request[?], messages: Messages)
    extends MainTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Contact form")

  override def pageContent = Grid.row(
    h2("Contact form"),
    contactFormValues.map { values =>
      Panel.panel(
        panelType = Panel.Companion.Type.Success,
        header = Some("Successfully submitted form!"),
        body = "Data received: " + values.toString
      )
    },
    formFrag
  )

  def formFrag =
    PF.form()(controllers.routes.HomeController.createForm())(
      Form.formFieldset("Contact data:")(
        PF.inputEmail()(contactForm("email"), label = "Email"),
        PF.inputPassword()(contactForm("password"), label = "Password"),
        PF.inputDate()(contactForm("dob"), label = "Date of birth")
      ),
      Form.formFieldset("Preferences:")(
        PF.inputRadio(
          contactForm("favoriteSuperHero"),
          Hero.All.map(h => (h.key, h.name, Nil)),
          label = "Super hero",
          checkedValue = Hero.All.head.key,
          isInline = false
        ),
        PF.inputSelect(multiple, size := "6")(
          contactForm("animals[]"),
          Animal.All.map { animal =>
            (animal.key, animal.name, Nil)
          },
          label = "Animals (multi-select)"
        )
      ),
      Form.inputSubmit(Classes.btnPrimary)("Submit")
    )
}
