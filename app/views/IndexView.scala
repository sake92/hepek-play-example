package views

import scalatags.Text.all._
import util.Imports._
import grid._

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

      Go to [form example](${linkTo(controllers.routes.HomeController.showForm)})
      """.md
  )

}
