Feature: Kiwisaver calculator functionalities

  Background:
    Given User is on Westpac's home page
    Then Navigates to Kiwisaver Calculators page
    And Clicks on Click here to get started button

  Scenario: The user is able to get a clear understanding of what needs to be entered in the field.
    Given User Clicks information icon besides Current age
    And Verifies the message "This calculator has an age limit of 18 to 64 years old."

    @New
   Scenario Outline: The users are able to plan their investments better.
     Given Users current age is "<age>"
     * is employed "<employmentstatus>"
     * with salary before tax "<salary>"
     And kiwisaver member contribution "<percent>"
     * with current kiwisaver balance "<currentksbalance>"
     And "<voluntarycontribution>" voluntary contribution with frequency "<frequency>"
     * selects risk profile "<riskprofile>"
     * for a savings goal "<savingsgoal>"
     And clicks on complete form button to see projected balance at retirement

     Examples:
      | age  | employmentstatus  | salary   | percent  | currentksbalance  | voluntarycontribution | frequency    | riskprofile   | savingsgoal |
      | 30   | Employed          | 82000    | 4%       |                   |                       |              | Growth        |             |
      | 45   | Self-employed     |          |          | 100000            | 90                    | fortnightly  | Balanced      | 290000      |
      | 55   | Not employed      |          |          | 140000            | 10                    | Annually     | Conservative  | 200000      |
