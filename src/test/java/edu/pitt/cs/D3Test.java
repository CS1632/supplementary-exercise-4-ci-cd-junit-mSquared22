// Generated by Selenium IDE
package edu.pitt.cs;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tEST1LINKS() {
    driver.get("https://cs1632.appspot.com/");
    // TEST-1-LINKS
    {
      WebElement element = driver.findElement(By.xpath("//html/body/div/header/nav/ul/li[8]/a"));
      String attribute = element.getAttribute("href");
      vars.put("href", attribute);
    }
    System.out.println(vars.get("href").toString());
    assertEquals(vars.get("href").toString(), "/reset");
  }
  @Test
  public void tEST2RESET() {
    driver.get("https://cs1632.appspot.com/");
    js.executeScript("javascript:document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";void(0)");
    driver.findElement(By.linkText("Reset")).click();
    assertThat(driver.findElement(By.xpath("//html/body/div/main/div[1]/div/ul/li[1]")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//html/body/div/main/div[1]/div/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//html/body/div/main/div[1]/div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST3CATALOG() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Catalog")).click();
    {
      WebElement element = driver.findElement(By.xpath("//html/body/div/main/div[1]/ol/li[2]/img"));
      String attribute = element.getAttribute("src");
      vars.put("src", attribute);
    }
    assertEquals(vars.get("src").toString(), "/images/cat2.jpg");
  }
  @Test
  public void tEST6RENT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Reset")).click();
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(1)")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(2)")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST4LISTING() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Catalog")).click();
    vars.put("count", driver.findElements(By.xpath("//html/body/div/main/div[1]/div/ul/li")).size());
    assertEquals(vars.get("count").toString(), "3");
    assertThat(driver.findElement(By.xpath("//html/body/div/main/div[1]/div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST5RENTACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    assertThat(driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).getText(), is("Rent"));
    assertThat(driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).getText(), is("Return"));
  }
  @Test
  public void tEST7RETURN() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(1)")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(2)")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.cssSelector(".list-group-item:nth-child(3)")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    assertThat(driver.findElement(By.cssSelector(".btn")).getText(), is("Feed"));
  }
  @Test
  public void tEST9FEED() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.cssSelector(".btn")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!Meow!"));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com/greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow! from Jennyanydots."));
  }
  @Test
  public void dEFECT1FEEDCAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.cssSelector(".jumbotron")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("-3");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.id("feedResult")).click();
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void dEFECT2GREETACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    driver.findElement(By.cssSelector("#greeting > h4")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!"));
  }
  @Test
  public void dEFECT3GREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com/rent-a-cat");
    driver.findElement(By.linkText("Reset")).click();
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.get("https://cs1632.appspot.com/greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.xpath("/html/body/div/main/div[1]/div[2]/h4")).getText(), is("Jennyanydots is not here."));
  }
}
