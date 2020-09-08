package com.example.demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

/**
 *
 *打开chrome浏览器，使用百度搜索，关闭浏览器
 */

public class openChrome {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
    );
    //实例化一个Chrome浏览器的实例
    WebDriver driver = new ChromeDriver();
    //设置打开的浏览器窗口最大化
    driver.manage().window().maximize();
    //设置隐性的等待时间
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    //使用get()打开一个网站
    driver.get("https://www.baidu.com");
    //getTitle()获取当前页面的title，用System.out.println()打印在控制台
    System.out.println("当前打开页面的标题是:" + driver.getTitle());
    //在搜索框输入文字
    driver.findElement(By.id("kw")).sendKeys("selenium");
    //点击搜索按钮
    driver.findElement(By.id("su")).click();
    //关闭浏览器
    driver.quit();
  }
}
