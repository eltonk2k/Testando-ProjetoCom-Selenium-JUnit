package br.pb.curso.teste;

import org.junit.Assert;
import org.junit.Test;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.pages.ContasPage;
import br.pb.curso.pages.MenuPage;

public class ContaTest extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	private static String mensagemSucesso = "Conta adicionada com sucesso!";
	private static String alteradaComSucesso = "Conta alterada com sucesso!";
	private static String mensagemErro = "Já existe uma conta com esse nome!";
	
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		
		contaPage.setNome("Conta do Teste");
		contaPage.salvar();
		Assert.assertEquals(mensagemSucesso, contaPage.obterMensagemSucesso());	
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contaPage.clicarAlterarConta("Conta do Teste");
		
		contaPage.setNome("Conta de Teste Alterada");
		contaPage.salvar();
		
		Assert.assertEquals(alteradaComSucesso, contaPage.obterMensagemSucesso());		
	}
	
	@Test
	public void testInserirContaMesmoNome() {
		
		menuPage.acessarTelaInserirConta();
		contaPage.setNome("Conta de Teste Alterada");
		contaPage.salvar();
		
		Assert.assertEquals(mensagemErro, contaPage.obterMensagemErro());
	}
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contaPage.clicarExcluirConta("Conta de Teste Alterada");
		
		Assert.assertEquals("Conta em uso na movimentações", contaPage.obterMensagemErro());
		
	}

}
