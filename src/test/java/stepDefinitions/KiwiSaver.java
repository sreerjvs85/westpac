package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import westpac.browserLibrary.BrowserFunctions;
import westpac.pages.HomePageObjects;
import westpac.pages.KiwiSaverPageObjects;

import java.io.IOException;

public class KiwiSaver {

    WebDriver webDriver;

    String employmentStatus;

    HomePageObjects homePageObjects;
    KiwiSaverPageObjects kiwiSaverPageObjects;

    @Given("User is on Westpac's home page")
    public void userIsOnWestpacSHomePage() {
        webDriver = BrowserFunctions.getDriver("chrome", "https://www.westpac.co.nz/");
        homePageObjects = new HomePageObjects(webDriver);
    }

    @Then("Navigates to Kiwisaver Calculators page")
    public void navigatesToKiwisaverCalculatorsPage() throws IOException {
        homePageObjects.clickBtnKiwiSaverCalculators();
    }

    @And("Clicks on Click here to get started button")
    public void clicksOnClickHereToGetStartedButton() throws IOException {
        kiwiSaverPageObjects = homePageObjects.clickBtnClickHereToGetStarted();
    }

    @Given("User Clicks information icon besides Current age")
    public void userClicksInformationIconBesidesCurrentAge() throws IOException {
        kiwiSaverPageObjects.clickIconCurrentAge();
    }

    @And("Verifies the message {string}")
    public void verifiesTheMessage(String expectedMessage) throws IOException {
        String actualMessage = kiwiSaverPageObjects.getTxtInfoCurrentAge();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Given("Users current age is {string}")
    public void usersCurrentAgeIs(String age) throws IOException {
        kiwiSaverPageObjects.setInputCurrentAge(age);
    }

    @And("is employed {string}")
    public void isEmployed(String employmentStatus) throws IOException {
        this.employmentStatus = employmentStatus;
        kiwiSaverPageObjects.setSelectEmploymentStatus(employmentStatus);
    }

    @And("with salary before tax {string}")
    public void withSalaryBeforeTax(String salaryBeforeTax) throws IOException {
        if (employmentStatus.toLowerCase().equals("employed")){
            kiwiSaverPageObjects.setInputSalaryBeforeTax(salaryBeforeTax);
        }
    }

    @And("kiwisaver member contribution {string}")
    public void kiwisaverMemberContribution(String membercontribution) throws IOException {
        if (employmentStatus.toLowerCase().equals("employed")){
            kiwiSaverPageObjects.setRadioMemberContributionList(membercontribution);
        }
    }

    @And("with current kiwisaver balance {string}")
    public void withCurrentKiwisaverBalance(String currentKSBalance) throws IOException {
        if (currentKSBalance.length() > 0){
            kiwiSaverPageObjects.setInputCurrentKiwiSaverBalance(currentKSBalance);
        }
    }

    @And("{string} voluntary contribution with frequency {string}")
    public void voluntaryContributionWithFrequency(String voluntaryContribution, String frequency) throws IOException {
        if (voluntaryContribution.length() > 0 && frequency.length() > 0){
            kiwiSaverPageObjects.setInputVoluntaryContributions(voluntaryContribution);
            kiwiSaverPageObjects.setSelectFrequency(frequency);
        }
    }

    @And("selects risk profile {string}")
    public void selectsRiskProfile(String riskProfile) throws IOException {
        if (riskProfile.length() > 0){
            kiwiSaverPageObjects.setRadioRiskProfileOption(riskProfile);
        }
    }

    @And("for a savings goal {string}")
    public void forASavingsGoal(String savingsGoal) throws IOException {
        if (savingsGoal.length() > 0){
            kiwiSaverPageObjects.setInputSavingsGoalAtRetirement(savingsGoal);
        }
    }

    @And("clicks on complete form button to see projected balance at retirement")
    public void clicksOnCompleteFormButtonToSeeProjectedBalanceAtRetirement() throws IOException {
        Assert.assertEquals(kiwiSaverPageObjects.clickBtnSeeProjections(),
                true,
                "Projected Kiwi Saver Value: " + kiwiSaverPageObjects.getTxtResultValue());
    }

    @After
    public void tearDown() {
        BrowserFunctions.quitDriver();
    }

}
