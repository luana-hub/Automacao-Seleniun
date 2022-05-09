import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.ui.Select;

public class TestCampoTreinamento {
	@Test
	// ESCREVA E PEGUE O VALOR DO CAMPO
	public void deveInteragirComTextField() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Luana");// .sendKeys-> quando vou escrever na tela
		driver.findElement(By.id("elementosForm:nome")).getAttribute("value");// getAttribute("volue") -> é quem pega o
																				// texto escrito
		Assert.assertEquals("Luana", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	// ESCREVA E PEGUE O VALOR NA ÁREA DE TEXTO
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Bem vindo!");
		driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");
		Assert.assertEquals("Bem vindo!", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}

	@Test
	// CLICAR NO RÁDIO BUTTON E CHECKBOX E VERIFICAR SE ESTÃO
	// MARCADOS(localizo,clico,confirmo se selecionou)
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:sexo:1")).isSelected();
		Assert.assertTrue("Feminino", driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
		driver.quit();
	}

	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected();
		Assert.assertTrue("Carne", driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	}

	@Test
	// SELECIONAR UMA OPÇÃO DO COMBO E VERIFICAR A OPÇÃO SELECIONADA
	public void deveInteragirComComboO() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
		/*
		 * OUTRAS FORMAS DE VALIDAR COMBO combo.selectByValue("2graucomp");
		 * combo.selectByIndex(3);
		 */
	}

	@Test
	// VERIFICAR VALORES DISPONÍVEIS NO COMBO
	public void deveVerificarValoresDisponiveisCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));// encontra o combo
		Select combo = new Select(element);// tranforma o combo numa instância do select
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());// verificar por tamanho da coleção
		// .getOptions() -> retorna uma lista de webElements
		boolean encontrou = false;// verificar que alguma opção determinada está disponível no combo
		for (WebElement option : options) {
			// se option pegar o texto mestrado então encontrou será verdaddeiro
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}

		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}

	@Test
	// SELECIONAR 3 VALORES AO MESMO TEMPO NO COMBO
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		List<WebElement> AllSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, AllSelectedOptions.size());

		combo.deselectByVisibleText("O que eh esporte?");
		AllSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, AllSelectedOptions.size());
		driver.quit();

		// 1-combo.getAllSelectedOptions() -> combo pegue todas as opções
		// 2-List<WebElement> AllSelectedOptions ->lista selecione todas as opções e
		// receba o pedido do combo
	}

	@Test
	// CLICK NO BOTÃO E VERIFIQUE SE O NOME DELE FOI TROCADO
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();

		/*
		 * SEGUNDA OPCÃO driver.findElement(By.id("buttonSimple")).click();
		 * driver.findElement(By.id("buttonSimple")).sendKeys("Obrigado!");
		 * Assert.assertEquals("Obrigado!",
		 * driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		 */
	}

	@Test
	// CLICK NO LINK E VERIFIQUE SE O NOME DELE FOI TROCADO (@ignore -> diz ao junit
	// pra não rodar o test)
	public void deveInteragirComLink() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.id("resultado")).getAttribute("value");
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.quit();
	}

	@Test

	// BUSQUE O TEXTO COMPLETO DA PAGINA E VERIFIQUE SE CONTÉM DETERMINADO TEXTO
	// NELE USANDO A TAG COMO LOCALIZADOR
	public void deveBuscarTextosNaPagina() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lferrsan\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\eclipseEstudo\\ProjetoAutomacaoWebSeleniun\\src\\main\\resources\\componentes.html");
		driver.manage().window().maximize();
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());	
		driver.quit();
		
		//SEGUNDA FORMA DE FAZER A BUSCA
		  //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(Campo de Treinamento);
		
		
	}

}
