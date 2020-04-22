package views.util

import scalatags.Text.all._
import Imports.Bundle._, Classes._

trait MainTemplate extends HtmlPage {

  private val formLink = controllers.routes.HomeController.showForm().url

  override def bodyContent =
    div(clsContainer)(
      Navbar.simple(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        left = List(
          hyperlink(formLink)("Form"),
          Navbar.simpleNestedLink(
            "Nested",
            List(hyperlink("#")("Nested1"), hyperlink("#")("Nested2"))
          )
        ),
        right = List(hyperlink("#")("Contact us"))
      ),
      pageContent
    )

  override def styleURLs =
    super.styleURLs ++
      List(controllers.routes.Assets.versioned("stylesheets/main.css").url)
}
