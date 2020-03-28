package views

import scalatags.Text.all._
import util.Imports._, grid._, Form._, Classes._

case class IndexView() extends util.MainTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Play Hepek")

  override def pageContent = row(
    s"""
      ## Welcome
      Some content..
      - one
      - two
      - test
    """.md,
    hyperlink(controllers.routes.HomeController.showForm.url)(
      button(btnClass, btnPrimary)("Go to contact form")
    )
  )

}
