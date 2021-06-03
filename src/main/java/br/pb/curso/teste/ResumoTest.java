package br.pb.curso.teste;

import org.junit.Assert;
import org.junit.Test;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.core.DriverFactory;
import br.pb.curso.pages.MenuPage;
import br.pb.curso.pages.ResumoPage;

public class ResumoTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
	
	@Test
	public void testResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}

}
