package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.i18n.I18nSupport
import ba.sake.hepek.play.implicits._
import forms.ContactForm

@Singleton
class HomeController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc)
    with I18nSupport {

  def index() = Action {
    Ok(views.IndexView())
  }

  def showForm() = Action { implicit request =>
    Ok(views.ContactFormView(ContactForm.form))
  }

  def createForm() = Action { implicit request =>
    ContactForm.form.bindFromRequest.fold(
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
