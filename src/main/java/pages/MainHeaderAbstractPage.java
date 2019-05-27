package pages;

import org.openqa.selenium.WebDriver;

public class MainHeaderAbstractPage extends BasePage {
	protected final String mainMenuXpath = "//div[@id='block_top_menu']";
	private final String tabXpath = mainMenuXpath + "//a[text()='%s']";
	private final String subMenuCss = "a[title='%s']";
	private final String viewCss = "a[title='%s']";

	public MainHeaderAbstractPage(WebDriver driver) {
		super(driver);
	}

}
