package ExecutePageClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.ExpenseCategory;
import pageClass.HomePageClass;
import pageClass.LoginPageClass;

public class ExpenseCategoryTestClass extends BaseClassTest {
	LoginPageClass lp;
	HomePageClass hp;
	ExpenseCategory ec;

	@Test(priority = 1,groups = {"create"})
	public void verifyToCreateNewExpense() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		ec = new ExpenseCategory(driver);

		lp.login("admin", "admin");
		hp.clickManageExpense();
		hp.clickExpenseCategory();

		ec.clickOnNew();
//		ec.typeOnTitle("Toast");
		ec.typeOnTitle(ec.readExcel(2,1));
		ec.clickOnSave();
		boolean actual = ec.newExpenseCategoryCreatedOrNot();
		boolean exp = true;
		Assert.assertEquals(actual, exp);

	}

	@Test(priority = 2,groups = {"search"})
	public void verifyToSearchCreatedExpense() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		ec = new ExpenseCategory(driver);

		lp.login("admin", "admin");
		hp.clickManageExpense();
		hp.clickExpenseCategory();

		ec.clickOnSearch();
//		ec.typeOnTitle("Toast");
		ec.typeOnTitle(ec.readExcel(2,1));
		ec.clickOnSearch1();
		boolean actual = ec.isToastDisplayedOrNot();
		boolean exp = true;
		Assert.assertEquals(actual, exp);
		ec.clickOnDeleteIcon();
		ec.alertAccept();
	}

	@Test(priority = 3 )
	public void verifyToDeleteCreatedExpense() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		ec = new ExpenseCategory(driver);

		lp.login("admin", "admin");
		hp.clickManageExpense();
		hp.clickExpenseCategory();

		ec.clickOnSearch();
//		ec.typeOnTitle("Toast");
		ec.typeOnTitle(ec.readExcel(2,1));
		
		ec.clickOnSearch1();
		boolean actual = ec.isToastDisplayedOrNot();
		boolean exp = true;
		Assert.assertEquals(actual, exp);
		ec.clickOnDeleteIcon();
		ec.alertAccept();
	}
}
