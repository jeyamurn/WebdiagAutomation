package testCases;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import wdMethods.ProjectMethods;

public class WebMonitor extends ProjectMethods{

	int i = 0;
	@Test(groups="smoke")
	public void monitor() throws Exception {

		input();

		for (int i=0; i< 2; i++)
		{
		Thread.sleep(3000);
		webappMonitor(strIP[i]);
		WebElement selectsys = locateElement("xpath", "(//a[@class = 'dropdown-toggle'])[3]");
		click(selectsys);
		Thread.sleep(3000);
		WebElement memInfo = locateElement("link", "Memory Info");
		click(memInfo);
		Thread.sleep(2000);
		takeSnap();
		scrollDown();
		takeSnap();
		Thread.sleep(2000);
		WebElement getmem = locateElement("xpath", "//html/body/div[2]/pre");
		String meminfo = getText(getmem);
		System.out.println(meminfo);
		
		Writer writer = null;
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C://Users//jeyamurn//.jenkins//workspace//Webdiag//traffic//traffic.txt"), "utf-8"));
		writer.write(meminfo);
		writer.close();
		
		
	/*	
		FileOutputStream out = new FileOutputStream("C://Users//jeyamurn//.jenkins//workspace//Webdiag//traffic//traffic.txt");
		out.write(meminfo.getBytes());
		out.close();*/


		Thread.sleep(3000);
		closeBrowser();
		//Thread.sleep(600000);
		//Thread.sleep(1800000);


		//}


		}
	}}