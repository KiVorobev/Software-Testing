import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChromeTest {
    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://e.mail.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    @AfterEach
    void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    @Order(1)
    void testLogin() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tpolab3@mail.ru");
        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lab3$777");
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.findElement(By.xpath("//img[@alt='tpolab3@mail.ru']")).click();
    }

    @Test
    @Order(2)
    void testSearchNoResult() {
        driver.findElement(By.xpath("//span[text()='Поиск по почте']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'mail-operands_dynamic-input__input')]")).sendKeys("TEST MESSAGE" + Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='По вашему запросу ничего не\u00a0найдено']"));
    }

    @Test
    @Order(3)
    void testSendMail() {
        driver.findElement(By.xpath("//div[text()='Сбросить поиск']")).click();
        driver.findElement(By.xpath("//span[text()='Написать письмо']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'contactsContainer')]//input")).sendKeys("tpolab3@mail.ru\n");
        driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("TEST LETTER");
        driver.findElement(By.xpath("//div[contains(@class,'cke_editable')]")).sendKeys("TEST MESSAGE");
        driver.findElement(By.xpath("//span[text()='Отправить']")).click();
        driver.findElement(By.xpath("//span[@title='Закрыть']")).click();
    }

    @Test
    @Order(4)
    void testSearchWithResult() {
        driver.findElement(By.xpath("//span[text()='Поиск по почте']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'mail-operands_dynamic-input__input')]")).sendKeys("TEST MESSAGE" + Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(@class,'llc_first')]"));
    }

    @Test
    @Order(5)
    void testDeleteMail() {
        driver.findElement(By.xpath("//div[text()='Сбросить поиск']")).click();
        driver.findElement(By.xpath("//div[@title='Выделить']")).click();
        driver.findElement(By.xpath("//div[text()='Удалить']")).click();
        driver.findElement(By.xpath("//div[text()='Очистить']")).click();
    }

    @Test
    @Order(6)
    void testClearTrash() {
        driver.findElement(By.xpath("//div[text()='Корзина']")).click();
        driver.findElement(By.xpath("//a[text()='Очистить папку']")).click();
        driver.findElement(By.xpath("//div[@class='layer__submit-button']")).click();
    }
}