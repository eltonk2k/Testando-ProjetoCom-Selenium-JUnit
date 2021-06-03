package br.pb.curso.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.pb.curso.core.DriverFactory;
import br.pb.curso.pages.LoginPage;
import br.pb.curso.teste.ContaTest;
import br.pb.curso.teste.MovimentacaoTest;
import br.pb.curso.teste.RemoveMovimentacaoContaTest;
import br.pb.curso.teste.ResumoTest;
import br.pb.curso.teste.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoveMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
	
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("elton@gmail.com");
		page.setSenha("123456");
		page.entrar();	
	}
	
	@AfterClass
	public static void finalizar() {
		DriverFactory.killDriver();
	}

}
