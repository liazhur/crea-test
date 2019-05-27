package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	// *********Constructor*********
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	@FindBy(css = "*[href='/fr']")
	private WebElement toggleFr;

	@FindBy(css = "*[href='/en']")
	private WebElement toggleEn;

	@FindBy(css = "#homeSearchTxt")
	private WebElement searchField;

	// *********Page Methods*********
	public WebElement getToggleFr() {
		return toggleFr;
	}

	public WebElement getToggleEn() {
		return toggleEn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

}
