import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
	@Test
	// CLICK NO ALERT,PEGUE A MSG E ESCREVA NO CAMPO NAME
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("alert")).click();

		// AUTERANDO O FOCO DO SELENIUN
		Alert alert = driver.switchTo().alert();// olhe para o alert
		Assert.assertEquals("Alert Simples", alert.getText());
		driver.switchTo().alert().accept();// olhe pto alert e aceite == clicar no ok para desaparecer
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Alert Simples");
		driver.quit();
	}

	@Test
	// CLICK NO CONFIRM E DÊ OK,PEGUE A MSG E /CLICK E CANCELE PEGUE A MSG
	public void deveInteragirComAlertConfirm() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
     	Assert.assertEquals("Confirm Simples", alert.getText());
     	alert.accept();
     	Assert.assertEquals("Confirmado", alert.getText());
     	alert.accept();
     	
     	driver.findElement(By.id("confirm")).click();
		 alert = driver.switchTo().alert();
     	Assert.assertEquals("Confirm Simples", alert.getText());
     	alert.dismiss();
     	Assert.assertEquals("Negado", alert.getText()); 	
     	driver.quit();  	
	}
	
	@Test
	// USADO PRA ENVIAR TEXTO PARA O USUÁRIO
	public void deveInteragirComAlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("39");
		alert.accept();
		Assert.assertEquals("Era 39?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		driver.quit();
	
	
	
	}
}
