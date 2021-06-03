package br.pb.curso.teste;

import org.junit.Assert;
import org.junit.Test;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.core.Propriedades;
import br.pb.curso.pages.HomePage;
import br.pb.curso.pages.MenuPage;

public class SaldoTest extends BaseTeste {
	
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menuPage.acessarHome();
		Assert.assertEquals("200.00", homePage.obterSaldo(Propriedades.NOME_CONTA_ALTERADA));
		
	}

}
