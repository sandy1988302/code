package com.example.demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

/**
 *
 * 在chrome打开湖南美术馆网站，进行用户登录/门票预约
 */

public class hnmsg {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
    );
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://www.hnmsg.net");
    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    System.out.println("当前打开页面的标题是:" + driver.getTitle());
    //点击登陆
    driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
    //切换到登录信息弹窗iframe
    driver
      .switchTo()
      .frame(driver.findElement(By.id("layui-layer-iframe100001")));
    //输入登录用户名和密码
    driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("chenhao");
    driver
      .findElement(By.xpath("//input[@id='password']"))
      .sendKeys("a3480855");
    driver.findElement(By.xpath("//a[contains(text(),'马上登录')]")).click();
    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    //从iframe切换回首页
    driver.switchTo().defaultContent();
    //进入门票预约，选择第一种门票
    driver.findElement(By.xpath("//a[@href='/toTicket']")).click();
    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    System.out.println("等待加载时间");
    driver
      .switchTo()
      .frame(driver.findElement(By.xpath("//span[contains(text(),'免费')]")));
    //向下滚动网页200像素
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("scrollBy(0, 200)");
    System.out.println("完成屏幕滚动");
    driver.findElement(By.xpath("//a[contains(text(),'个人预约')]")).click();
    //输入个人预约信息,使用默认的预约参观日期

    // driver.findElement(By.xpath("//input[@id='userPhone']")).sendKeys("13874995433");
    // driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("陈昊");
    // driver.findElement(By.xpath("//input[@id='certificateNum']")).sendKeys("43108119880909049X");
    // driver.findElement(By.xpath("//a[contains(text(),'立即预约')]")).click();

  }
}
