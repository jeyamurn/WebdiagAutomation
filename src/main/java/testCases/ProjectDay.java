package testCases;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class ProjectDay extends ProjectMethods{

	@Test(invocationCount=2,groups="sanity")

	public void loginWebapp() throws Exception {

		//for (int i = 0; i<=2; i++) {
					

			//Below steps will take screenshot of system alert

			Thread.sleep(3000);
			webappDebug();
			Thread.sleep(3000);
			WebElement selectinfo = locateElement("xpath", "(//a[@class = 'dropdown-toggle'])[1]");
			click(selectinfo);
			Thread.sleep(3000);
			WebElement sysalert = locateElement("link", "System Alerts");
			click(sysalert);
			Thread.sleep(3000);
			takeSnap();
			Thread.sleep(3000);
			scrollDown();
			Thread.sleep(3000);
			takeSnap();
			Thread.sleep(3000);
			WebElement selectVOIP = locateElement("xpath", "(//a[@class= 'dropdown-toggle'])[4]");
			click(selectVOIP);
			Thread.sleep(3000);
			WebElement selectvoipInfo = locateElement("link", "VoIP Information");
			click(selectvoipInfo);
			Thread.sleep(3000);
			WebElement selectvoipdsp = locateElement("xpath", "(//a[@class= 'dropdown-toggle'])[8]");
			click(selectvoipdsp);
			Thread.sleep(3000);
			WebElement selectDSP = locateElement("link", "DSP status");
			click(selectDSP);
			Thread.sleep(3000);
			takeSnap();
			Thread.sleep(2000);
			
			closeBrowser();

			Thread.sleep(7200);


	//}

}
}


