package westpac.pages;

import westpac.commonLibrary.WebElementFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;

public class HomePageObjects {

    public final WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy (how = How.ID, using = "ubermenu-section-link-kiwisaver-ps")
    WebElement lnkKiwiSaver;

    @FindBy (how = How.ID, using = "ubermenu-item-cta-kiwisaver-calculators-ps")
    WebElement btnKiwiSaverCalculators;

    @FindBy(how = How.LINK_TEXT, using = "Click here to get started.")
    WebElement btnClickHereToGetStarted;

    public void clickBtnKiwiSaverCalculators() throws IOException {
        WebElementFunctions.moveToElement(lnkKiwiSaver);
        WebElementFunctions.click(btnKiwiSaverCalculators);
    }

    public KiwiSaverPageObjects clickBtnClickHereToGetStarted() throws IOException {
        WebElementFunctions.click(btnClickHereToGetStarted);
        return new KiwiSaverPageObjects(driver);
    }


}
