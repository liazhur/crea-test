package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.SubMenu;
import steps.BasicSteps;
import utilities.Listeners.TestListener;
import utils.Log;
import utils.ExtentReports.ExtentTestManager;

@Listeners({ TestListener.class })
@Epic("Functional Test")
@Feature("Checkout Tests")
public class ProductCheckoutTest extends BaseTest {

	@DataProvider(name = "products")
	public static Object[][] getProductsMap() {
		return new Object[][] { { SubMenu.SUMMER_DRESSES, "Printed Chiffon Dress", "M" } };
	}

	@Test(priority = 1, dataProvider = "products", description = "Basic checkout flow")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: basic flow of selecting a product, registering an account and proceeding through checkout.")
	@Story("Automate scenario: selecting product flow")
	public void productCheckoutScenario(SubMenu subMenu, String productName, String size) throws InterruptedException {
//		Log.info(method.getName() + " test is starting.");

		// ExtentReports Description
		ExtentTestManager.getTest().setDescription("Product Checkout Flow Scenario");

		// *************PAGE INSTANTIATIONS*************
		BasicSteps basicStep = new BasicSteps(driver, wait);

		// *************STEP METHODS********************
		Log.info("Opening Store website.");
		basicStep.openHomePage();

	}

}
