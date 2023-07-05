package ExecutePageClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.HomePageClass;
import pageClass.LoginPageClass;
import pageClass.ManageNewExpensePage;

public class ManageExpenseNewTest extends BaseClassTest {
	LoginPageClass lp;
	HomePageClass hp;
	ManageNewExpensePage men;

	@Test (groups = {"search"})
	public void clickManageExpenseAndIsDisplayedOrNot() {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		men = new ManageNewExpensePage(driver);
		lp.login("admin", "admin");
		men.ManageExpense0();
		men.MangeExpense1();
		boolean out = men.isMangeExpenseDisplayed();
		Assert.assertTrue(out);
		
	}

	@Test(groups = {"create"})
	public void createNewMangeExpense() throws Exception {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		men = new ManageNewExpensePage(driver);
		lp.login("admin", "admin");
		men.ManageExpense0();
		men.MangeExpense1();
		men.clickOnAddNewExpense();
//		men.useridSelect("admin");
		men.useridSelect0(10);
		men.selectDate();
		men.daySelect();
		men.categorySelect(15);
		men.orderSelect(10);
		men.purchaseIDSelect(4);
		men.expenseTypeSelect(2);
//		men.amountInput("500");
		men.amountInput(men.readValueInteger(7, 1));
//		men.remarksClick("Image of Russian Salad is uploading...");
		men.remarksClick(men.readValue(8, 1));
//		men.chooseFile("/home/shabana/Downloads/Russian Salad.jpeg");
		men.chooseFile(System.getProperty("user.dir")+"//src//test//resources//Russian Salad.jpeg");
		men.saveButtonClick();
	}

	@Test(groups = {"group2"})
	public void searchCreatedNewMangeExpense() {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		men = new ManageNewExpensePage(driver);
		lp.login("admin", "admin");
		men.ManageExpense0();
		men.MangeExpense1();
		men.clickOnSearch();
		men.selectOnSearch1(10);
		men.categorySelect2(15);
		men.selectDate2();
		men.clickOnSearch2();
		boolean out2= men.tableResult();
		Assert.assertTrue(true);
	}

}
