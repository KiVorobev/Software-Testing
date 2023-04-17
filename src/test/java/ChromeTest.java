import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeTest {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://e.mail.ru/");
    }

    @Test
    void testLogin() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tpolab3@mail.ru");
        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lab3$777");
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.xpath("//img[@alt='tpolab3@mail.ru']")).click();
    }
}