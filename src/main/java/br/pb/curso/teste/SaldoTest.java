package br.pb.curso.teste;

import org.junit.Assert;
import org.junit.Test;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.pages.HomePage;

public class SaldoTest extends BaseTeste {
	
	HomePage homePage = new HomePage();
	
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("200.00", homePage.obterSaldo("Conta de Teste Alterada"));
		
	}

}
