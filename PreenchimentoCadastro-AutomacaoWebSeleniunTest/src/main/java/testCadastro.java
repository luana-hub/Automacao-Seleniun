import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testCadastro{
	

	private ChromeDriver driver;

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
	public void deveRealizarCadastroComSucesso() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Amanda");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomez");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("2o grau completo");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));//  startsWith -> COMEÇA COM
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Amanda"));        // endsWith -> TERMINA COM
		Assert.assertEquals("Sobrenome: Gomez",driver.findElement(By.id("descSobrenome")).getText()); // OUTRA MANEIRA PEGANDO O TEXTO INTEIRO
		Assert.assertEquals("Sexo: Feminino",driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne",driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: 2graucomp",driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Corrida",driver.findElement(By.id("descEsportes")).getText());
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());	
	}
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Roberta");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());	
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Roberta");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rodrigues");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());	
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Roberta");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rodrigues");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());	
	}
	
	@Test
	public void deveValidarEsporteIndesiso() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Roberta");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rodrigues");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();		
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	}
}
