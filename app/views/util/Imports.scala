package views.util

import ba.sake.hepek.play.PlayBundleImpl
// try different bundles:
import ba.sake.hepek.bootstrap3.BootstrapBundle
import ba.sake.hepek.bulma.BulmaBundle
import ba.sake.hepek.w3css.W3CssBundle

object Imports {

  val Bundle = BootstrapBundle()
  val PlayBundle = PlayBundleImpl(Bundle)

}
