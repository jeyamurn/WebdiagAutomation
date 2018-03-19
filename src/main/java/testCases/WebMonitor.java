package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import wdMethods.ProjectMethods;

public class WebMonitor extends ProjectMethods{
	
	int i = 0;
	@Test(invocationCount=2,groups="smoke")
	public void monitor() throws Exception {

		//for (int i=0; i<=2; i++) {

			Thread.sleep(3000);
			webappMonitor();
			Thread.sleep(3000);
			WebElement selectsys = locateElement("xpath", "(//a[@class = 'dropdown-toggle'])[3]");
			click(selectsys);
			Thread.sleep(3000);
			WebElement memInfo = locateElement("link", "Memory Info");
			click(memInfo);
			Thread.sleep(3000);
			WebElement getmem = locateElement("xpath", "//html/body/div[2]/pre");
			String meminfo = getText(getmem);
			
			
			System.out.println(meminfo);

			Thread.sleep(3000);
			closeBrowser();

			Thread.sleep(7200);
				

		//	}
		
			

}}