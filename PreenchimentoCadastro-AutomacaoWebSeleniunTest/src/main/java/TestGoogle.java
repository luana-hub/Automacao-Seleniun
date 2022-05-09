import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestGoogle {
	@Test
	public  void test() {	
		//driver me informe o titulo(resultado esperado o quero receber/resultado atual a açao do browser)
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

}
