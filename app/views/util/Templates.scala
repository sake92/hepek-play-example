package views.util

import scalatags.Text.all._
import Imports._

trait MainTemplate extends HtmlPage {

  private val formLink = controllers.routes.HomeController.showForm().url

  override def bodyContent =
    div(cls := bootstrapContainer)(
      Navbar.simple(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        right = List(hyperlink(formLink)("Contact us"))
      ),
      pageContent
    )

  override def styleURLs =
    super.styleURLs ++
      List(controllers.routes.Assets.versioned("stylesheets/main.css").url)
}
