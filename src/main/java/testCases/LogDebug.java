
package testCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class LogDebug extends ProjectMethods{
	

@Test	//(priority=1) //(invocationCount=2,groups="regression",dependsOnGroups="sanity")
	public void log() throws Exception {
		
		//Below steps will download logdebug files
		
		for (int i = 0; i<=2; i++) {
		
		Thread.sleep(3000);;
		webappMonitor();
		focus();
		Thread.sleep(3000);
		focus();
		WebElement selectsys1 = locateElement("xpath", "(//a[@class = 'dropdown-toggle'])[3]");
		click(selectsys1);
		Thread.sleep(3000);
		focus();
		WebElement downloadLog = locateElement("link", "Dump System");
		click(downloadLog);
		Thread.sleep(3000);
		focus();
		refresh();
		Thread.sleep(2000);
		focus();
		WebElement dwlLogdebug = locateElement("link", "Debug and log files");
		click(dwlLogdebug);
		Thread.sleep(3000);
		focus();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		focus();
		System.out.println("Download is successfull");
		closeBrowser();
		
		Thread.sleep(600000);
		//Thread.sleep(1800000);
	}



}
}
