package log4jUsingBasicConfigurator;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jBasicConfiguratorExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:/ARIJIT_10052015/selenium/selenium drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//BasicConfigurator.configure();
		
		Logger log1=Logger.getLogger(Log4jBasicConfiguratorExample.class);
		System.out.println("***11nov2017-2318***");
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%d{HH:mm} %-5p %F %50.50c - %m%n")));
		
		
		driver.get("http://newtours.demoaut.com/");
		log1.info("Logging into newtours website");
		
		driver.manage().window().maximize();
		log1.debug("maximising windows");
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
	}
}
