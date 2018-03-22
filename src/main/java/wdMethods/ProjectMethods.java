package wdMethods;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ProjectMethods extends SeMethods {

	
	public String[] strIP= new String[2];
	public String[] strPwd = new String[2];
	public void input() throws IOException {


/*
		FileInputStream inputStream = new FileInputStream("C:\\Users\\jeyamurn\\Desktop\\Resource.txt");     
		String everything = IOUtils.toString(inputStream);
		System.out.println(everything);
		return everything;	*/
		
		
		FileInputStream fstream = new FileInputStream("C:\\Users\\jeyamurn\\Desktop\\Resource.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		
		int i=0;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		  String [] tokens = strLine.split("\\s");
		  System.out.println("tokens[0]:"+tokens[0]);
		  System.out.println("tokens[0]:"+tokens[1]);
		  strIP[i] = tokens[0];
		  strPwd[i] = tokens[1];
		  
		  System.out.println (strIP[i]);
		  System.out.println (strPwd[i]);
		  i++;
		}

		//Close the input stream
		br.close();
		
		
	}

	public void webappDebug(String pStrIp, String pStrPwd) throws InterruptedException, IOException {
		

		startApp("firefox", "https://"+pStrIp+"/services/webapp/debug");
		WebDriverWait mywait = new WebDriverWait(driver, 15);
		if (mywait.until(ExpectedConditions.alertIsPresent()) !=null) {
			driver.switchTo().alert().sendKeys("wdt"+Keys.TAB+pStrPwd);
			acceptAlert();
		}
		else if (mywait.until(ExpectedConditions.alertIsPresent()) ==null) 
		{

			dismissAlert();
		}
		

	}

	public void webappMonitor(String pStrIp) throws InterruptedException, IOException {

		
		startApp("firefox", "https://"+pStrIp+"/services/webapp/monitor");
		WebDriverWait mywait1 = new WebDriverWait(driver, 15);
		if (mywait1.until(ExpectedConditions.alertIsPresent()) !=null) {
			driver.switchTo().alert().sendKeys("installer"+Keys.TAB+"Pbxk1064");
			acceptAlert();
		}

		else if (mywait1.until(ExpectedConditions.alertIsPresent()) ==null) 
		{

			dismissAlert();
		}


	}


}


