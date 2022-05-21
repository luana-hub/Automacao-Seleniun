import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestGoogle {
	
	private ChromeDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/lferrsan/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}

	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public  void test() {	
		//driver me informe o titulo(resultado esperado o quero receber/resultado atual a açao do browser)
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
	}

}
