package br.pb.curso.pages;

import br.pb.curso.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldo(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
	

}
