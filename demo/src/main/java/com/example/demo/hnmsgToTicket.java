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

public class hnmsgToTicket {

  public static void main(String[] args) {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
    );
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://192.168.206.142:8084/");
    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    System.out.println("当前打开页面的标题是:" + driver.getTitle());
    //点击登陆
    driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
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
    driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    System.out.println("等待加载时间");
    //向下滚动网页400像素
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("scrollBy(0, 400)");
    System.out.println("为了点击个人预约按钮进行屏幕滚动");
    System.out.println("当前浏览器标题为：" + driver.getTitle());
    driver.findElement(By.linkText("个人预约")).click();
    //输入个人预约信息,使用默认的预约参观日期
    driver.findElement(By.name("userPhone")).sendKeys("13874995433");
    driver.findElement(By.name("userName")).sendKeys("陈昊");
    js.executeScript("scrollBy(0, 300)");
    System.out.println("为了输入身份证进行屏幕滚动");
    driver.findElement(By.id("certificateNum")).click();
    driver.findElement(By.id("certificateNum")).sendKeys("431081198809097034");
    driver.findElement(By.xpath("//a[contains(text(),'立即预约')]")).click();
    driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    js.executeScript("scrollBy(0, 300)");
  }
}
