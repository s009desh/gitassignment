package facebook.com.facebook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcasesenrios {
	
	public static void main( String[] args )
    {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\s009d\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement usernameInputNegative = driver.findElement(By.id("user-name"));
        usernameInputNegative.sendKeys("dummy_user");
        WebElement passwordInputNegative = driver.findElement(By.id("password"));
        passwordInputNegative.sendKeys("invalid_password");
        WebElement loginButtonNegative = driver.findElement(By.id("login-button"));
        loginButtonNegative.click();

        

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Test Passed: Error message is displayed correctly.");
        } else {
            System.out.println("Test Failed: Error message is not as expected.");
        }

        driver.quit();
    }

}
