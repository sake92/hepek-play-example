package views.util

import ba.sake.hepek.play.PlayBundle
import ba.sake.hepek.play.HepekPlayForm
import ba.sake.hepek.bootstrap3.BootstrapBundle

object Imports extends PlayBundle with BootstrapBundle {

  /* this customization is optional! */

  val customForm = Form.withFormType(Form.Companion.Type.Horizontal())
  override val hf = new HepekPlayForm(customForm)

  val grid = Grid.withScreenRatios(
    Grid.screenRatios.withAll(Ratios().withSingle(1, 2, 1).withThird(1, 2, 1))
  )
    
}
