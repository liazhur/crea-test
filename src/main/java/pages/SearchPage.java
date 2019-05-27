package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[id=txtMapSearchInput]")
	private WebElement searchField;

	public WebElement getSearchField() {
		return searchField;
	}
}
