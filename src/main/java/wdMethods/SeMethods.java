package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods{

	RemoteWebDriver driver;
	int i=1;


	public void startApp(String browser, String url) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_32.exe");		
			driver = new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver_32bit.exe");		
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\MicrosoftWebDriver.exe");		
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("var pr=prompt('Enter your URL please:',''); alert(pr);");  
		Thread.sleep(15000L);
		String URL = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.get(URL);*/
		driver.get(url);
		        
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The Browser "+browser+" is launched");
	}

	public WebElement locateElement(String locator, String locValue) {
		switch (locator){
		case "id":
			return driver.findElementById(locValue);
		case "name":
			return driver.findElementByName(locValue);
		case "class":
			return driver.findElementByClassName(locValue);
		case "xpath":
			return driver.findElementByXPath(locValue);
		case "link":
			return driver.findElementByLinkText(locValue);
		default: return null;
		}

	}

	public WebElement locateElement(String locValue) {
		return locateElement("id", locValue);		
	}

	public void type(WebElement ele, String data) {
		ele.clear();
		ele.sendKeys(data);
		System.out.println(""+data+" is typed");
	}

	public void click(WebElement ele) {
		ele.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(""+ele+" is clicked");
	}


	public void clickWithoutSnap(WebElement ele) {
		ele.click();

	}

	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		Select dropdown = new Select(ele); 
		dropdown.selectByVisibleText(value);
		System.out.println(""+value+" is Selected");
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select dropdown = new Select(ele);
		dropdown.selectByIndex(index);
		System.out.println(""+index+" is Selected");

	}

	public boolean verifyTitle(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println(expectedTitle + " is the title");
		}
		else {

			System.out.println("expected title is not found");
		}
		return false;
	}
	public void verifyExactText(WebElement ele, String expectedText) {
		String actualText = ele.getText();

		if (actualText.contentEquals(expectedText)) {
			System.out.println(actualText);
		}
		else {

			System.out.println("Text not Matched");

		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		String actualtext = ele.getText();
		if (actualtext.contains(expectedText)) {
			System.out.println(actualtext + "    Expected text is matched");
		}

		else {
			System.out.println("Partial text not matched");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		Set<String> allwin = driver.getWindowHandles();
		List<String> list = new ArrayList<String>();
		list.addAll(allwin);
		driver.switchTo().window(list.get(index));
		System.out.println("switched to mergelead window");

	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}


	public void acceptAlert() {

		driver.switchTo().alert().accept();
		System.out.println("Webapp login is successfull");

	}


	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		System.out.println("Merge is not successfull");

	}

	public String getAlertText() {
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage + "is the alert message");
		return(null);

	}

	public long takeSnap() {


		/*	File scrFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snap/TrafficTest"+i+".jpeg");
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;*/

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;

	}

	public void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed");


	}

	public void closeAllBrowsers() {
		driver.quit();
		System.out.println("All windows are closed");

	}

	public void scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void refresh() {

		driver.navigate().refresh();

	}

	public void focus() {


		((JavascriptExecutor) driver).executeScript("window.focus();");
	}




}
