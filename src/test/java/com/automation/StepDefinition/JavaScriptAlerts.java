package com.automation.StepDefinition;

import org.openqa.selenium.By;
import com.automation.core.BaseClass;

import io.cucumber.java.en.*;

public class JavaScriptAlerts  extends BaseClass {
    final String BROWSER = "chrome"; //chrome, firefox, edge

    // @Given("a user is on the website home page")
    // public void a_user_is_on_the_website_home_page() {
    //     BaseClass.launchBrowserWithWebsiteHomePage(BROWSER);
    // }

    @When("user clicks on JavaScript Alerts")
    public void user_clicks_on_javascript_alerts() {
        webDriver.findElement(By.xpath("//a[normalize-space()='JavaScript Alerts']")).click();
    }

    @Then("user clicks on button JS Alert and clicks Ok button on the Alert")
    public void user_clicks_on_button_JS_Alert_and_clicks_Ok_button_on_the_Alert() throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert();
        webDriver.switchTo().alert().accept();
        if (webDriver.findElement(By.xpath("//p[@id='result']")).getText()
                .contains("You successfully clicked an alert")) {
            System.out.println("'Click for JS Alert' successfully tested");
        }
    }
    
    @And("user clicks on button JS Confirm  and click Confirm button on the Alert")
    public void user_clicks_on_button_JS_Confirm_and_click_Confirm_button_on_the_Alert() throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert();
        webDriver.switchTo().alert().accept();
        if (webDriver.findElement(By.xpath("//p[@id='result']")).getText().contains("You clicked: Ok")) {
            System.out.println("'Click for JS Confirm' successfully tested");
        }   
    }
    
    @And("user clicks on button JS Prompt and user enter text then click Ok button")
    public void user_clicks_on_button_JS_Prompt_and_user_enter_text_then_click_Ok_button() throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert();
        webDriver.switchTo().alert().sendKeys("This is testing text");
        String text = webDriver.switchTo().alert().getText();
        webDriver.switchTo().alert().accept();
        if (webDriver.findElement(By.xpath("//p[@id='result']")).getText()
                .contains("You entered:")) {
            System.out.println("Entered text: " + text);
            System.out.println("'Click for JS Prompt' successfully tested");
        }       
    }
}
