import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class letskodProject extends Main{
    @Test
    public void gotoWeb() {
        driver.get("https://www.letskodeit.com");

    }

    @Test
    public void clickPractice() {
        driver.get("https://www.letskodeit.com/");
        driver.findElement(By.cssSelector("#navbar-inverse-collapse > ul > li:nth-child(6)")).click();
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> itr = windowIds.iterator();
        String parentwindowId = itr.next();
        String childwindowId = itr.next();
        driver.switchTo().window(childwindowId);
        driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
    }

    @Test
    public void switchWindowButonExample() throws InterruptedException {
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.xpath("//button[@class='btn-style class1']")).click();
        Set<String> windvB = driver.getWindowHandles();
        Iterator<String> rep = windvB.iterator();
        String practiceWindow = rep.next();
        String windovB = rep.next();
        driver.switchTo().window(windovB);
        //Thread.sleep(400);
        driver.close();
    }

    @Test
    public void tabButton() throws InterruptedException {
        driver.get("https://www.letskodeit.com/practice");
        WebElement tabButton = driver.findElement(By.xpath("//a[@id='opentab']"));
        tabButton.click();
        Set<String> tabWindow = driver.getWindowHandles();
        Iterator<String> lup = tabWindow.iterator();
        String prakWindow = lup.next();
        String tabWindov = lup.next();
        driver.switchTo().window(tabWindov);
        //Thread.sleep(800);
        driver.quit();
    }

    @Test
    public void enableDisablButton() {
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.id("enabled-button")).click();
        driver.findElement(By.cssSelector("#enabled-example-input")).sendKeys("almost there");

    }

    @Test
    public void hideShowButon() {
        driver.get("https://www.letskodeit.com/practice");
        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        hideButton.isDisplayed();
        if (hideButton.isDisplayed()) {
            System.out.println("it's not displayed");
        } else {
            System.out.println("it is displayed ");
        }
    }

    @Test
    public void svitchToAlert() {
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        driver.quit();
    }

    @Test
    public void mouseHover() throws InterruptedException {
        driver.get("https://www.letskodeit.com/practice");
        WebElement mHover = driver.findElement(By.id("mousehover"));
        Actions hover = new Actions(driver);
        hover.moveToElement(mHover).perform();
        hover.click(mHover).perform();
        driver.findElement(By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]")).click();
        // Thread.sleep(200);
        driver.quit();

    }

    @Test
    public void multiSelectionMenu() {
        driver.get("https://www.letskodeit.com/practice");
        WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiSelect);
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(2);
        List<WebElement> menuOptions = select.getAllSelectedOptions();
    }

    @Test
    public void autoSuggetsExample() {
        driver.get("https://www.letskodeit.com/practice");
        WebElement sugstExam = driver.findElement(By.id("autosuggest"));
        sugstExam.sendKeys("bmw x5");
        sugstExam.click();
    }

}
