package wdMethods;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectMethods extends SeMethods {

	
	public void webappDebug() throws InterruptedException {


		startApp("firefox", "https://192.168.5.35/services/webapp/debug");
		WebDriverWait mywait = new WebDriverWait(driver, 15);
		if (mywait.until(ExpectedConditions.alertIsPresent()) !=null) {
		driver.switchTo().alert().sendKeys("wdt"+Keys.TAB+"daFTzz8OjhF2HTRnEMs_igx5btVlF0BrMXyfl4RF6jpNnIKe7jcKG3RYgWjgwwwS48nzN6hUWKsJheaVrka_Y72ZsHT2RhClwKEtSRs3cp35noPkxYGIRhi9FAEhgL0tAY8dp+i1D46ZOlQozknVPdoHBNPc29Usw+llZSjwfyf2bemw");
		acceptAlert();
		}
		else if (mywait.until(ExpectedConditions.alertIsPresent()) ==null) 
			{
			
			dismissAlert();
		}
	}
	public void webappMonitor() throws InterruptedException {

		startApp("firefox", "https://192.168.5.35/services/webapp/monitor");
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


