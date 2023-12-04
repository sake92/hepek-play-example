package controllers

import javax.inject.*
import play.api.*
import play.api.mvc.*
import play.api.i18n.I18nSupport
import ba.sake.hepek.html.HtmlPage
import ba.sake.hepek.play.given
import forms.ContactForm

@Singleton
class HomeController @Inject() (cc: ControllerComponents)
    extends AbstractController(cc)
    with I18nSupport {

  def index() = Action {
    Ok(views.IndexView)
  }

  def showForm() = Action { implicit request: Request[?] =>
    Ok(views.ContactFormView(ContactForm.form))
  }

  def createForm() = Action { implicit request: Request[?] =>
    ContactForm.form
      .bindFromRequest()
      .fold(
        errors => {
          println(s"Got form errors: $errors")
          BadRequest(views.ContactFormView(errors))
        },
        value => {
          println(s"Got form value: $value")
          val filledForm = ContactForm.form.fill(value)
          Ok(views.ContactFormView(filledForm, Some(value)))
        }
      )
  }

}
