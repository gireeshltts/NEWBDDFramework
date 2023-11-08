
Feature: Launch my demo app

  @mobile
  Scenario: verify user successfully launch app
  given valid APK uploaded in browserstack
  When user launches app
  Then app should install in mobile and open main menu.