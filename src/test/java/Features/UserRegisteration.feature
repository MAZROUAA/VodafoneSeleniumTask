Feature: User Registration
  I want to check that user can sign up successfully.

  Scenario Outline: User Registration
    Given  the user in the home page
    When I click on Sign up button in Header
    And  I entered the "<username>" , "<password>"
    Then The “Sign up successful.” message appears successfully
    Examples:
      | username | password
      | User7898 | 1234
      | User7899 | 1234
