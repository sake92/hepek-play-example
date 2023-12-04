package views.util

import Bundle.*, Tags.*, Classes.*

trait MainTemplate extends Page {

  private val formLink = controllers.routes.HomeController.showForm().url

  override def bodyContent =
    div(clsContainer)(
      Navbar.simple(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        left = List(
          a(href := formLink)("Form"),
          Navbar.simpleNestedLink(
            "Nested",
            List(a(href := "#")("Nested1"), a(href := "#")("Nested2"))
          )
        ),
        right = List(a(href := "#")("Contact us"))
      ),
      pageContent
    )

  override def styleURLs =
    super.styleURLs ++
      List(controllers.routes.Assets.versioned("stylesheets/main.css").url)
}
