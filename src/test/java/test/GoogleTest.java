package test;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	WebDriver nav;

	@Before
	public void setUp() {
		// Mudar a versão do webdriver de acordo com a versão do chrome
		// para consultar a versão do chrome é so acessar chrome://version
		System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver-ver105.exe");
		nav = new ChromeDriver();
	}

	@After
	public void tearDown() {
		nav.manage().deleteAllCookies();
		// nav.close();
	}

	@Test
	public void testSearch() {
		nav.get("https://google.com");
		nav.findElement(By.cssSelector(
				"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"))
				.click();
		nav.findElement(By.cssSelector(
				"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"))
				.sendKeys("puc minas", Keys.ENTER);
		nav.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")).click();
		nav.navigate().back();
		nav.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input")).click();
		nav.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input")).clear();
		nav.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input")).sendKeys("Microsoft",
				Keys.ENTER);
	}

	@Test
	public void testGoogleMaps() {
		nav.get("https://google.com/maps");
		nav.findElement(By.id("searchboxinput")).click();
		nav.findElement(By.id("searchboxinput")).sendKeys(
				"PUC Minas - Ed. Fernanda - Prédio 4 - Rua Cláudio Manoel - Savassi, Belo Horizonte - MG", Keys.ENTER);
		nav.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		nav.findElement(By.xpath("//*[@id=\"QA0Szd\"]/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/div[1]/button"))
				.click();

		nav.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).click();
		nav.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).sendKeys("PUC Minas - Coração Eucarístico",
				Keys.ENTER);
		nav.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		nav.findElement(By.xpath("//*[@id=\"section-directions-trip-0\"]")).click();
	}

}
