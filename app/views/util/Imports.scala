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

  // nice centering grid
  object grid extends Grid {
    override def screenRatios =
    super.screenRatios.withAll(Ratios(Ratio(1, 1), Ratio(1, 2, 1)))
  }
}
