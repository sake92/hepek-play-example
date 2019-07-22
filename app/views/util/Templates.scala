package views.util

import scalatags.Text.all._
import Imports._

trait MainTemplate extends HtmlPage {

  private val linkForm = linkTo(controllers.routes.HomeController.showForm())

  override def bodyContent =
    div(cls := bootstrapContainer)(
      Navbar.navbar(
        brandUrl = "/",
        brandName = Some("My Company Ltd."),
        brandIconUrl = Some("https://img.icons8.com/color/48/000000/company.png"),
        right = List(
          hyperlink(linkForm)("Contact us") -> Seq.empty
        )
      ),
      pageContent
    )

  override def styleURLs =
    super.styleURLs ++ List(asset("stylesheets/main.css"))
}
