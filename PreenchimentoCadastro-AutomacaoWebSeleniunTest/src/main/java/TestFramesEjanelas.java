import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFramesEjanelas {
	

	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	// CLICK NO BOTÃO FRAME ,PEGUE A FRASE E ESCREVA NO CAMPO NOME
	public void deveInteragirComFrames() {
		driver.switchTo().frame("frame1"); // DRIVER OLHE PRO FRAME
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}

	@Test
	// CLICK NO BOTÃO ESCREVER NO POPUP,FECHAR E ESCREVA NO TEXTAREA
	public void deveInteragirComJanelas() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup"); // MUDANDO O FOFO DO SELENIUM PARA UM POPUP(JANELA)
		driver.findElement(By.tagName("textarea")).sendKeys("Olá Mundo!");
		driver.close();
		driver.switchTo().window(""); // RETORNANDO PRA JANELA PRINCIPAL DO DRIVER
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Seja Bem Vindo!");

	}

	@Test
	// DESCOBRINDO IDENTIFICAÇÃO DA JANELA COM WindowHandle
	public void deveInteragirComJanelasSemTitulo() {
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Hello!");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);// voltando a janela principal atraves do array																			 
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Seja Bem Vindo!");
	}

}
