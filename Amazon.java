package com.hexaware.amazon;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aaron\\eclipse-workspace\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();     
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=11626261458450976390&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9154740&hvtargid=kwd-10573980&hydadcr=14453_2316415");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.titleContains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
        
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("mobile");

        // Wait for the suggestion to be clickable and click it
        
        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-flyout-searchAjax\"]/div[2]/div/div[1]/div[7]/div/div/span")));
        suggestion.click();
        
        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        mobile.click();
        
        String parent_handle= driver.getWindowHandle();
        System.out.println(parent_handle);
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for(String handle1:handles)
            if(!parent_handle.equals(handle1))
            {
                driver.switchTo().window(handle1);            
                break;
            }	

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button[type='submit']")));
        addToCart.click();
        
        WebElement proceedToPay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")));
        proceedToPay.click();
        
        wait.until(ExpectedConditions.titleContains("Select a delivery address"));
        WebElement address = driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input"));
        address.click();
        
        WebElement payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"SelectableAddCreditCard\"]")));
        payment.click();
        
//        WebDriverWait wait1 = new WebDriverWait(driver, 40);
//        WebElement signIn = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ap_email\"]")));
//        signIn.sendKeys("aaronsabu52@gmail.com");
//        WebElement contin = driver.findElement(By.xpath("//span[@id=\"continue\"]"));
//        contin.click();
        
        WebElement cardDetails = driver.findElement(By.xpath("//*[@id=\"apx-add-credit-card-action-test-id\"]/div/img[1]"));
        cardDetails.click();
        
     // Switch to frame by name or ID
        Thread.sleep(5000);
        driver.switchTo().frame("ApxSecureIframe");
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name=\"addCreditCardNumber\"]"));
        cardNumber.click();
        cardNumber.sendKeys("111111111111");
        
    }
}
