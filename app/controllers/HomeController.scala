package controllers

import javax.inject.*
import play.api.*
import play.api.mvc.*
import play.api.i18n.I18nSupport
import ba.sake.hepek.html.HtmlPage
import ba.sake.hepek.play.given
import models.CreateCustomer

@Singleton
class HomeController @Inject() (cc: ControllerComponents)
    extends AbstractController(cc)
    with I18nSupport {

  def index() = Action {
    Ok(views.IndexView)
  }

  def showForm() = Action { implicit request: Request[?] =>
    Ok(views.CreateCustomerView(CreateCustomer.form))
  }

  def submitForm() = Action { implicit request: Request[?] =>
    CreateCustomer.form
      .bindFromRequest()
      .fold(
        errorForm => {
          println(s"Got form with errors: ${errorForm}")
          BadRequest(views.CreateCustomerView(errorForm))
        },
        formData => {
          println(s"Got form data: ${formData}")
          val filledForm = CreateCustomer.form.fill(formData)
          Ok(views.CreateCustomerView(filledForm))
        }
      )
  }

}
