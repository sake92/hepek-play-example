package views.util

import ba.sake.hepek.play.PlayBundle
import ba.sake.hepek.bootstrap3.BootstrapBundle
import ba.sake.hepek.play.HepekPlayForm

object Imports extends PlayBundle with BootstrapBundle {

  object customForm extends Form { // default is vertical
    override def formType = Form.Type.Horizontal()
  }

  override val hf = new HepekPlayForm {
    override type FormImpl = Form
    val fc = customForm
  }
}
