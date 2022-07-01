package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
public static WebDriver driver;
public static Actions a;
public static Robot r;
public static JavascriptExecutor js;
public static void launchBrowser() {
System.setProperty("webdriver.chrome.driver","C:\\Users\\GOWTHAM\\eclipse-workspace\\FrameWork\\drivers\\chromedriver.exe" );
	driver = new ChromeDriver();
}
public static void passUrl(String url) {
driver.get(url);
}
public static void toMaximize() {
driver.manage().window().maximize();
}
public static void toInput(WebElement element, String input) {
element.sendKeys(input);
}
private void toClick(WebElement element) {
element.click();
}
public static void toClose() {
driver.close();
}
public static void toQuit() {
driver.quit();
}
public static void toGetTile() {
driver.getTitle();
}
public static void toGetCurrentUrl() {
driver.getCurrentUrl();
}
public static void toGetText(WebElement element) {
element.getText();
}
public static void toGetAttributeValue(WebElement element, String s) {
element.getAttribute(s);
}
public static void toMoveToElement(WebElement element) {
a = new Actions(driver);
a.moveToElement(element).perform();
}
public static void toDragAnddrop(WebElement src, WebElement dst) {
a = new Actions(driver);
a.dragAndDrop(src, dst).perform();
}
public static void toClickAndHold(WebElement element) {
a = new Actions(driver);
a.clickAndHold(element).perform();
}
public static void toDoubleClick(WebElement element) {
a = new Actions(driver);
a.doubleClick(element).perform();
}
public static void toRightClick(WebElement element) {
a = new Actions(driver);
a.contextClick(element).perform();
}
public static void toAcceptAlert() {
Alert a = driver.switchTo().alert();
a.accept();
}
public static void toCancelAlert() {
Alert a = driver.switchTo().alert();
a.dismiss();
}
public static void toTextAlert(String s) {
Alert a = driver.switchTo().alert();
a.sendKeys(s);
}
public static void toPressDown() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_DOWN);
}
public static void toPressUp() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_UP);
}
public static void toPressTab() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_TAB);
}
public static void toPressEnter() throws AWTException {
r = new Robot();
r.keyPress(KeyEvent.VK_ENTER);
}
public static void toReleaseDown() throws AWTException {
r = new Robot();
r.keyRelease(KeyEvent.VK_DOWN);
}
public static void toReleaseUp() throws AWTException {
r = new Robot();
r.keyRelease(KeyEvent.VK_UP);
}
public static void toReleaseTab() throws AWTException {
r = new Robot();
r.keyRelease(KeyEvent.VK_TAB);
}
public static void toReleaseEnter() throws AWTException {
r = new Robot();
r.keyRelease(KeyEvent.VK_ENTER);
}
public static void toSendKeysFaster(WebElement element, String s) {
js = (JavascriptExecutor)driver;
Object o = js.executeScript(s, element); 
}
public static void toGetTextFaster(WebElement element) {
js = (JavascriptExecutor)driver;
Object o = js.executeScript("return arguments[0].getAttribute('value')", element);
}
public static void toClickFaster(WebElement element) {
js = (JavascriptExecutor)driver;
Object o = js.executeScript("arguments[0].click()",element);
}
public static void toScrollDown(WebElement element) {
js = (JavascriptExecutor)driver;
Object o = js.executeScript("arguments[0].scrollIntoView('true')",element);
}
public static void toScrollUp(WebElement element) {
js = (JavascriptExecutor)driver;
Object o = js.executeScript("arguments[0].scrollIntoView('flase')",element);
}
public static void screenshot(String filename) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File("C:\\Users\\GOWTHAM\\eclipse-workspace\\FrameWork\\Screenshot\\"+filename);
	FileUtils.copyDirectory(src, dst);
}
public static void toHandleWindows(Integer windowindex) {
Set<String> windowHandles = driver.getWindowHandles();
List<String> li = new ArrayList<>();
li.addAll(windowHandles);
driver.switchTo().window(li.get(windowindex));
}
public static void toSelectIndex(WebElement element, Integer x) {
Select s = new Select(element);
List<WebElement> options = s.getOptions();
for(int i=0; i<options.size();i++) {
WebElement element2 = options.get(x);
System.out.println(element2.getText());
}
}
public static void toGetFirstSeelectedoption(WebElement element, Integer x) {
	Select s = new Select(element);
	List<WebElement> options = s.getOptions();
	for(int i=0; i<options.size();i++) {
	WebElement element2 = options.get(x);
	System.out.println(element2.getText());
	}
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	System.out.println(firstSelectedOption.getText());
}
public static void toDeSelectAll(WebElement element) {
	Select s = new Select(element);
	s.deselectAll();
}
public static void toImplicitwWait(Integer timeinsec) {
driver.manage().timeouts().implicitlyWait(timeinsec, TimeUnit.SECONDS);
}

}
