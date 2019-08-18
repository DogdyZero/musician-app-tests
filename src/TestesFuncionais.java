import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesFuncionais {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/douglas/eclipse/Selenium-Driver/geckodriver-v0.23.0-linux64/geckodriver");

		driver = new FirefoxDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.get("http://localhost:4200");

	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void loginEfetuadoComSucesso() throws Exception {
		driver.findElement(By.name("guitarra1")).click();
		driver.findElement(By.name("btn_comprar_prod")).click();
		driver.findElement(By.name("btn_comprar_cart")).click();
	    driver.findElement(By.name("usuario_user")).sendKeys("douglas");
	    driver.findElement(By.name("btn_login")).click();
	  }
	  @Test
	  public void loginComDigitacaoErrada() throws Exception {
		driver.findElement(By.name("guitarra1")).click();
		driver.findElement(By.name("btn_comprar_prod")).click();
		driver.findElement(By.name("btn_comprar_cart")).click();
	    driver.findElement(By.name("usuario_user")).sendKeys("gabriel");
	    driver.findElement(By.name("btn_login")).click();
	    assertEquals("Login ou senha digitadas estão erradas",driver.findElement(By.className("ui-messages-detail")).getText());
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }


}
