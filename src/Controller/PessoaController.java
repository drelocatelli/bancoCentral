package Controller;

import java.util.ArrayList;

import Model.Pessoa;

public class PessoaController {
	
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

	public static ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public static void setPessoas(Pessoa pessoa) {
		PessoaController.pessoas.add(pessoa);
	}
	
	public static void consulta() {
		System.out.println(pessoas.toString());
	}
	
}
