package login;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class sparesFinder {
//    WebElement searchBox;
WebDriver driver;

    @Test
    public void openPage() {
        String uName="NgaD", pWord="012345678x@X";

        System.setProperty("webdriver.chrome.driver", "D:/risk_register_user_roles_issue/AUTOMATION/source/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://subscribertestvdc.sparesfinder.com/");
        driver.manage().window().maximize();//maximize screen
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//delay 10s


        //login page
        driver.findElement(By.id("Body_tbUsername")).sendKeys(uName);
        driver.findElement(By.id("Body_tbPassword")).sendKeys(pWord);
        driver.findElement(By.id("Body_btnSignIn")).click();

//        Actions hover = new Actions(driver);
//        WebElement corpMenu = driver.findElement(By.xpath("//td[@id='KaminoMPV4']//p//a//img"));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        hover.moveToElement(corpMenu);
//
//        WebElement subMenu = driver.findElement(By.xpath("//img[@src=\"http://portaltestvdc.sparesfinder.com/images/MasterpieceV4ALT.png\"]"));
//        hover.moveToElement(subMenu);
//        hover.click().build().perform();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().frame("MyFrameTwo");//switch to frame contain element
        WebElement menu1= driver.findElement(By.xpath("//td[@id='KaminoMPV4']//p//a//img"));
        Hover(driver, menu1);
//        WebElement menu= driver.findElement(By.xpath("//tr[3]//td[1]//table[1]"));
//        Hover(driver, menu);
//        WebElement menu2= driver.findElement(By.xpath("//td[@id='KaminoMPV4']//p//a//img"));
//        Hover(driver, menu2);



//        HoverAndClick(driver, driver.findElement(By.xpath("//img[@src=\"http://portaltestvdc.sparesfinder.com/images/MasterpieceV4ALT.png\"]")));
    }

    public static void Hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void HoverAndClick(WebDriver driver,WebElement elementToHover,WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

//    driver.close();
}
