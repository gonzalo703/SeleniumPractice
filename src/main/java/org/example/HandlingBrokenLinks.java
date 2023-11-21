
package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class HandlingBrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        Iterator<WebElement> var4 = links.iterator();

        while(var4.hasNext()) {
            WebElement link = var4.next();
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)(new URL(url)).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            boolean var10001 = responseCode < 400;
            String var10002 = link.getText();
            a.assertTrue(var10001, "The link with text: " + var10002 + " is broken with code: " + responseCode);
            a.assertAll();
        }

    }
}
