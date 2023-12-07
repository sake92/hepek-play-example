package views

import PlayBundle.Bundle.*, Tags.*

object IndexView extends MainTemplate:

  override def pageSettings =
    super.pageSettings.withTitle("Play Hepek")

  override def pageContent = Grid.row(
    s"""
      ## Welcome
      Some content..
      - one
      - two
      - test
    """.md,
    a(href := controllers.routes.HomeController.showForm().url)(
      button(Classes.btnClass, Classes.btnPrimary)("Go to contact form")
    )
  )
