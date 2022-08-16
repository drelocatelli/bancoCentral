import Utils.BuildMenu;
import Utils.MenuCallback;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Controller.PessoaController;
import Model.Pessoa;

public class Program {
	
	private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Bem vindo ao banco central\n");
        menuPrincipal();
    }

    private static void menuPrincipal() {
        
        var menuItems = new LinkedHashMap<String, MenuCallback>();
        menuItems.put("Cadastrar pessoas", new MenuCallback() {
			@Override
			public void doSomething() {
				System.out.printf("Digite o nome: ");
				
				String nome = input.nextLine();
				
				System.out.printf("Digite a idade: ");
				int idade = input.nextInt();
				input.nextLine();
				
				PessoaController.setPessoas(new Pessoa(nome, idade));
				
			}
		});
        
        menuItems.put("Consultar pessoas", new MenuCallback() {
			@Override
			public void doSomething() {
				PessoaController.consulta();
				
			}
		});
        
        menuItems.put("Cadastrar saldo", new MenuCallback() {
			@Override
			public void doSomething() {
				System
				.out.println("Cadastrando saldos");
				
			}
		});
 
    	new BuildMenu("Escolha uma opcao:", menuItems);
        
     
    }

}
