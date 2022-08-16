import Utils.BuildMenu;
import Utils.MenuCallback;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import Model.Pessoa;
import Model.Saldo;

public class Program {
	
	private static Scanner input = new Scanner(System.in);
	
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        System.out.printf("Bem vindo ao banco central\n");
        pessoas.add(new Pessoa("Ana"));
        menuPrincipal();
    }

    private static void menuPrincipal() {
        
        var menuItems = new LinkedHashMap<String, MenuCallback>();
        menuItems.put("Cadastrar pessoas", new MenuCallback() {
			@Override
			public void doSomething() {
				System.out.printf("Digite o nome: ");
				String nome = input.nextLine();
			
				pessoas.add(new Pessoa(nome));
				
			}
		});
        
        menuItems.put("Consultar pessoas", new MenuCallback() {
			@Override
			public void doSomething() {
				if(pessoas.size() == 0) {
					System.out.println("Nenhuma pessoa cadastrada.");
				} else {
					System.out.println(pessoas.toString());	
				}
			}
		});
        
        menuItems.put("Cadastrar saldo", new MenuCallback() {
			@Override
			public void doSomething() {
				if(pessoas.size() == 0) {
					System.out.println("Nenhuma pessoa encontrada.");
					return;
				}
				
				for(int i = 0; i < pessoas.size(); i++) {
					System.out.printf("%d - %s \n", i, pessoas.get(i).getNome());
				}
				
				System.out.printf("Selecione uma pessoa: ");
				int selected = input.nextInt();
				
				System.out.printf("Digite o saldo de %s: ", pessoas.get(selected).getNome());
				double saldo = input.nextDouble();
				
				double newSaldo = pessoas.get(selected).getSaldo() + saldo;
				pessoas.get(selected).setSaldo(new Saldo(newSaldo));
				
			}
		});
        
        menuItems.put("Cadastrar despesa", new MenuCallback() {
			@Override
			public void doSomething() {
				if(pessoas.size() == 0) {
					System.out.println("Nenhuma pessoa encontrada.");
					return;
				}
				
				for(int i = 0; i < pessoas.size(); i++) {
					System.out.printf("%d - %s \n", i, pessoas.get(i).getNome());
				}
				
				System.out.printf("Selecione uma pessoa: ");
				int selected = input.nextInt();
				
				System.out.printf("Digite a despesa de %s: ", pessoas.get(selected).getNome());
				double saldo = input.nextDouble();
				
				double newSaldo = pessoas.get(selected).getSaldo() - saldo;
				pessoas.get(selected).setSaldo(new Saldo(newSaldo));
				
			}
		});
 
    	new BuildMenu("Escolha uma opcao:", menuItems, "Sair", "Prossiga [Enter]");
     
    }

}
