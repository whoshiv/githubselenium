package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	//testng mai scope change karna hai to PROJECT in pom.xml
	// kab kaise use karna hai -- ask
	
	//pre condition aur post condition aata hai
	
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	
	@BeforeClass
	public void bc() throws IOException
	{
		String browserName = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
		
		// yaha par if laga sakte hai ???? script mai if else nahi laga sakte hai
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		}
	
	@AfterClass
	public void ac()
	{
        driver.quit();
	}
}
