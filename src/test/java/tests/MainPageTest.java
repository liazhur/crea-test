package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import steps.BasicSteps;
import utilities.Listeners.TestListener;
import utils.Log;

@Listeners({ TestListener.class })
@Epic("Functional Test")
@Feature("Main Page Tests")
public class MainPageTest extends BaseTest {

	@DataProvider(name = "languages")
	public static Object[][] getLanguage() {
		return new Object[][] { { "fr" }, { "en" } };
	}

	@DataProvider(name = "keyWords")
	public static Object[][] getKeyWord() {
		return new Object[][] { { "Ottawa" }, { "Saint John" } };
	}

	@Test(dataProvider = "languages")
	public void toggleSwitchTest(String language) {
		// *************PAGE INSTANTIATIONS*************
		BasicSteps basicStep = new BasicSteps(driver, wait);

		// *************STEP METHODS********************
		Log.info("Opening website.");
		basicStep.openHomePage();

		basicStep.verifyLanguageToggleSwitch(language);
		System.out.println();
	}

	@Test(dataProvider = "keyWords")
	public void basicSearchTest(String keyWord) {
		// *************PAGE INSTANTIATIONS*************
		BasicSteps basicStep = new BasicSteps(driver, wait);

		// *************STEP METHODS********************
		basicStep.openHomePage();
		basicStep.searchEnter(keyWord);
		basicStep.verifySearch(keyWord);
	}

}
