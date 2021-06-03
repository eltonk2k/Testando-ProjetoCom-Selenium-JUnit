package br.pb.curso.teste;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.core.Propriedades;
import br.pb.curso.pages.ContasPage;
import br.pb.curso.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	private static String mensagemSucesso = "Conta adicionada com sucesso!";
	private static String alteradaComSucesso = "Conta alterada com sucesso!";
	private static String mensagemErro = "Já existe uma conta com esse nome!";
	
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		
		
		contaPage.setNome("Conta do Teste");
		contaPage.salvar();
		Assert.assertEquals(mensagemSucesso, contaPage.obterMensagemSucesso());	
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contaPage.clicarAlterarConta("Conta do Teste");
		
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvar();
		
		Assert.assertEquals(alteradaComSucesso, contaPage.obterMensagemSucesso());		
	}
	
	@Test
	public void test3_InserirContaMesmoNome() {
		
		menuPage.acessarTelaInserirConta();
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvar();
		
		Assert.assertEquals(mensagemErro, contaPage.obterMensagemErro());
	}
	
	

}
