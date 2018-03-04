@mobile @main-activity
Feature: Main activity basic behaviour

  @main-activity-screen-1
  Scenario: Main activity. Screen 1 elements visibility
    When I launch app
    Then I should be redirected to main screen
    And main screen should have visible first screen text '30 Tags'
    And main screen should have visible icons with the following ids
      | icon_4  |
      | icon_11 |
      | icon_12 |
      | icon_19 |

  @main-activity-screen-5
  Scenario: Main activity. Screen 5 elements visibility
    Given I launch app
    Then I should be redirected to main screen
    When I swipe through the whole main screen from right to left 4 times
    Then I should remain on main screen
    And main screen should have edit view layout
    And main screen should have visible grid view
    And main screen should have password tip
    """
    Hey!
    Welcome to use CoCoin!
    To protect your account book,
     you need a password to do so.
    """
