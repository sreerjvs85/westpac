package westpac.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import westpac.commonLibrary.WebElementFunctions;

import java.io.IOException;
import java.util.List;

public class KiwiSaverPageObjects {
    public final WebDriver webDriver;

    public KiwiSaverPageObjects(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='calculator-embed']/iframe")
    WebElement iFrameCalculator;

    @FindBy(how = How.XPATH, using = "//button[@class='icon-target icon-target-help-toggle icon-btn icon-btn-info ir ng-scope']")
    WebElement iconCurrentAge;

    @FindBy(how = How.XPATH, using = "//div[@class='field-message message-info ng-binding']")
    WebElement txtInfoCurrentAge;

    @FindBy(how = How.XPATH, using = "//div[@class='control-cell ng-scope ng-isolate-scope']//input")
    WebElement inputCurrentAge;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']")
    WebElement selectEmploymentStatus;

    @FindAll(
        @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-employment-status field-group ng-isolate-scope']//ul[@class='option-list']/li"))
    List<WebElement> selectEmploymentStatusOptions;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-annual-income field-group ng-scope ng-isolate-scope']//input")
    WebElement inputSalaryBeforeTax;

    @FindAll(
            @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-kiwisaver-member-contribution field-group ng-scope ng-isolate-scope']//div[contains(@class,'control radio-control  radio-control-default-label')]"))
    List<WebElement> radioMemberContributionList;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-kiwi-saver-balance field-group ng-isolate-scope']//input[@class='ng-pristine ng-valid']")
    WebElement inputCurrentKiwiSaverBalance;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//input[@class='ng-pristine ng-valid']")
    WebElement inputVoluntaryContributions;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//div[@class='control select-control  no-selection']")
    WebElement selectFrequency;

    @FindAll(
            @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-voluntary-contributions field-group ng-isolate-scope']//ul[@class='option-list']//li"))
    List<WebElement> selectFrequencyOptions;

    @FindAll(
            @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-risk-profile field-group ng-isolate-scope']//div[contains(@class,'control radio-control  radio-control-default-label')]"))
    List<WebElement> radioRiskProfileList;

    @FindBy(how = How.XPATH, using = "//div[@class='wpnib-field-savings-goal field-group ng-isolate-scope']//input[@class='ng-pristine ng-valid']")
    WebElement inputSavingsGoalAtRetirement;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-regular btn-results-reveal btn-has-chevron']")
    WebElement btnSeeProjections;

    @FindBy(how = How.XPATH, using = "//div[@class='results-header']")
    WebElement txtResultMessage;

    @FindBy(how = How.XPATH, using = "//span[@class='result-value result-currency ng-binding']")
    WebElement txtResultValue;

    public String getTxtResultValue() throws IOException {
        return WebElementFunctions.getMessage(txtResultValue);
    }

    public void switchToiFrameCalculator() throws IOException {
        WebElementFunctions.switchToFrame(iFrameCalculator);
    }

    public void clickIconCurrentAge() throws IOException {
        switchToiFrameCalculator();
        WebElementFunctions.click(iconCurrentAge);
    }

    public String getTxtInfoCurrentAge() throws IOException {
        return WebElementFunctions.getMessage(txtInfoCurrentAge);
    }

    public void setInputCurrentAge(String currentAge) throws IOException {
        switchToiFrameCalculator();
        WebElementFunctions.fillField(inputCurrentAge,currentAge);
    }

    public void setSelectEmploymentStatus(String employmentStatus) throws IOException {
        WebElementFunctions.click(selectEmploymentStatus);
        int index = WebElementFunctions.getElementIndex(selectEmploymentStatusOptions, employmentStatus);
        WebElementFunctions.click(selectEmploymentStatusOptions.get(index+1));
    }

    public void setInputSalaryBeforeTax (String salaryBeforeTax) throws IOException {
        WebElementFunctions.fillField(inputSalaryBeforeTax, salaryBeforeTax);
    }

    public void setInputCurrentKiwiSaverBalance(String kiwiSaverBalance) throws IOException {
        WebElementFunctions.fillField(inputCurrentKiwiSaverBalance,kiwiSaverBalance);
    }

    public void setInputVoluntaryContributions(String voluntaryContributions) throws IOException {
        WebElementFunctions.fillField(inputVoluntaryContributions,voluntaryContributions);
    }

    public void setSelectFrequency(String frequency) throws IOException {
        WebElementFunctions.click(selectFrequency);
        int index = WebElementFunctions.getElementIndex(selectFrequencyOptions, frequency);
        WebElementFunctions.click(selectFrequencyOptions.get(index+1));
    }

    public void setRadioMemberContributionList(String option) throws IOException {
        int index = WebElementFunctions.getElementIndex(radioMemberContributionList, option);
        WebElementFunctions.click(radioMemberContributionList.get(index));
    }

    public void setRadioRiskProfileOption(String option) throws IOException {
        int index = WebElementFunctions.getElementIndex(radioRiskProfileList, option);
        WebElementFunctions.click(radioRiskProfileList.get(index));
    }

    public void setInputSavingsGoalAtRetirement(String inputSavingsGoalAtRetirement) throws IOException {
        WebElementFunctions.fillField(this.inputSavingsGoalAtRetirement,inputSavingsGoalAtRetirement);
    }

    public boolean clickBtnSeeProjections() throws IOException {
        WebElementFunctions.click(btnSeeProjections);
        return WebElementFunctions.isWebelementPresent(txtResultMessage);
    }


}
