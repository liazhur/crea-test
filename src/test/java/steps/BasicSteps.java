package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;
import pages.HomePage;
import pages.MainHeaderAbstractPage;
import pages.SearchPage;
import utils.Log;
import utils.WebDriverHelper;
import utils.WebProperties;

public class BasicSteps extends MainHeaderAbstractPage {

	public BasicSteps(WebDriver driver, WebDriverWait wait) {
		super(driver);
	}

	@Step("Go to Home Page")
	public void openHomePage() {
		driver.get(WebProperties.URL);
		Log.info("Go to Home Page");
	}

	@Step("Verify browser url after toggle switch")
	public void verifyLanguageToggleSwitch(String language) {
		HomePage home = new HomePage(driver, wait);

		if (language == "fr") {
			if (!home.getToggleFr().getAttribute("class").toString().contains("selected")) {
				home.getToggleFr().click();
				WebDriverHelper.waitNextAction(driver, 10);
				Assert.assertEquals(driver.getCurrentUrl(), WebProperties.URL + "/" + language);

			} else {
				home.getToggleEn().click();
				WebDriverHelper.waitNextAction(driver, 10);
				home.getToggleFr().click();
				WebDriverHelper.waitNextAction(driver, 10);
				Assert.assertEquals(driver.getCurrentUrl(), WebProperties.URL + "/" + language);
			}
		}

		if (language == "en") {
			if (!home.getToggleEn().getAttribute("class").toString().contains("selected")) {
				home.getToggleEn().click();
				WebDriverHelper.waitNextAction(driver, 10);
				Assert.assertEquals(driver.getCurrentUrl(), WebProperties.URL + "/" + language);
			} else {
				home.getToggleFr().click();
				WebDriverHelper.waitNextAction(driver, 10);
				home.getToggleEn().click();
				WebDriverHelper.waitNextAction(driver, 10);
				Assert.assertEquals(driver.getCurrentUrl(), WebProperties.URL + "/" + language);
			}

		}

	}

	@Step("VMake search and press enter")
	public void searchEnter(String keyWord) {
		HomePage home = new HomePage(driver, wait);

		home.getSearchField().sendKeys(keyWord);
		home.getSearchField().sendKeys(Keys.ENTER);

	}

	@Step("Verify search")
	public void verifySearch(String keyWord) {
		SearchPage searchPage = new SearchPage(driver, wait);
		String actual = searchPage.getSearchField().getText();
		Assert.assertTrue(actual.contains(keyWord));

	}
}
