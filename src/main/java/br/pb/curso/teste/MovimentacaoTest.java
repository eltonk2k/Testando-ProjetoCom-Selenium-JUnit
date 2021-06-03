package br.pb.curso.teste;

import static br.pb.curso.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.pb.curso.core.BaseTeste;
import br.pb.curso.pages.MenuPage;
import br.pb.curso.pages.MovimentacaoPage;
import br.pb.curso.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTeste {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	private static String dataPagamento = "02/09/2017";
	private static String descricao = "Qualquer coisa movimentação";
	private static String valor = "200";
	private static String interessado = "Seu Zé";
	private static String mensagem = "Movimentação adicionada com sucesso!";
	
	@Test
	public void test1InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Qualquer coisa");
		movPage.setInteressado(interessado);
		movPage.setValor(valor);
		movPage.setConta("Conta de Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals(mensagem, movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();	
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		
//		movPage.setDataMovimentacao("01/06/2024");
//		movPage.setDataPagamento("01/06/2025");
		movPage.setDescricao(descricao);
		movPage.setInteressado(interessado);
		movPage.setValor(valor);
		movPage.setConta("Conta de Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
//		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.obterMensagemDataMovimentacao());
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual")));
		Assert.assertEquals(1, erros.size());
	}

}
