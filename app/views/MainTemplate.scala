package views

import PlayBundle.Bundle.*, Tags.*, Classes.*

trait MainTemplate extends Page {

  private val formLink = controllers.routes.HomeController.showForm().url

  override def bodyContent =
    div(clsContainer)(
      Navbar.nav(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        left = List(
          Navbar.link(formLink, "Form"),
          Navbar.dropdown(
            "Nested",
            List(
              Navbar.dropdownLink("#", "Nested1"),
              Navbar.dropdownLink("#", "Nested2")
            )
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
