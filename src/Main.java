import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Main {
  WebDriver driver;
  private long implicitlyWait=30;
  @BeforeMethod
    public void setDriver(){
      System.setProperty("webdriver.driver.chromedriver", "/Users/saida/Documents/drivers/chromedriver");
              driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));

          }

  }

}
