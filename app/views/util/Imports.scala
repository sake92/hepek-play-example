package views.util

import ba.sake.hepek.play.PlayBundle
import ba.sake.hepek.play.HepekPlayForm
import ba.sake.hepek.bootstrap3.BootstrapBundle
import ba.sake.hepek.html.component.BasicComponents

object Imports extends PlayBundle with BootstrapBundle with BasicComponents {

  object customForm extends Form {
    override def formType = Form.Type.Horizontal()
  }

  override val hf = new HepekPlayForm {
    override type FormImpl = Form
    val fc = customForm
  }

  object grid extends Grid {
    override def screenRatios =
      super.screenRatios.withAll(Ratios().withSingle(1, 2, 1).withThird(1, 2, 1))
  }

  def linkTo(routeCall: play.api.mvc.Call): String =
    routeCall.url

  def asset(assetPath: String): String =
    controllers.routes.Assets.versioned(controllers.Assets.Asset(assetPath)).url
}
