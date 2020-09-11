package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testWait2 {

  public static void testWait(WebDriver driver) {
    driver.get("D:\\code\\github\\demo\\src\\web\\set_timeout.html");

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(
      ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box"))
    );
    WebElement element = driver.findElement(By.cssSelector(".red_box"));
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].style.border = \"5px solid yellow\"",
        element
      );
  }
}
