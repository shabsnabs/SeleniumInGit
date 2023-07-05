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

public class HomePageTestClass extends BaseClassTest {
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test (groups = {"group1"})
  public void verifyAllTileDisplayed() {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  
	  lp.login("admin", "admin");
	  boolean actual=hp.isAllElementDisplayed();
	  Assert.assertTrue(actual);
  }
}
