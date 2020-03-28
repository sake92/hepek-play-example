package views

import util.Imports._, grid._

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

      Go to [contact form](${controllers.routes.HomeController.showForm.url})
      """.md
  )

}
