package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;
	public Logger logger;

	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		logger=LogManager.getLogger(this.getClass());
		PageFactory.initElements(driver, this);
		
	}

	public void timeUnitSleepMili(int time) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(time);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
}
