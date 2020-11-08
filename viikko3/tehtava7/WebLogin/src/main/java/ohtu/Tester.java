package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4567");
        Random r = new Random();
        sleep(2);

//        // User can login to account with valid username and password
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        sleep(2);
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));       
//        sleep(2);
//        element.submit();

//        // User login to account with valid username and incorrect password
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        sleep(2);
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep2");
//        element = driver.findElement(By.name("login"));       
//        sleep(2);
//        element.submit();

        // User creates new account
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("timmisalasana1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("timmisalasana1");
        element = driver.findElement(By.name("signup"));       
        sleep(2);
        element.submit();
        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(3);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
