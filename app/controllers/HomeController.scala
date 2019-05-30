package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.i18n.I18nSupport
import ba.sake.hepek.play.implicits._
import forms.ExampleForm

@Singleton
class HomeController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc)
    with I18nSupport {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.ExampleFormView(ExampleForm.form))
  }

  def createForm() = Action { implicit request =>
    ExampleForm.form.bindFromRequest.fold(
      errors => {
        println(s"Got form errors: $errors")
        BadRequest(views.ExampleFormView(errors))
      },
      value => {
        println(s"Got form value: $value")
        val filledForm = ExampleForm.form.fill(value)
        Ok(views.ExampleFormView(filledForm, Some(value)))
      }
    )
  }
}
