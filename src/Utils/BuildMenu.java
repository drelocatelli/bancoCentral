package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class BuildMenu {

	private static Scanner input = new Scanner(System.in);
	public int total = 0;
	private int index = 0;

	public BuildMenu(String question, HashMap<String, MenuCallback> items, String... exit) {
		total = items.size() + 1;
		
		int opt = 0;
		while(true) {
			buildMenuCatalog(question, items, exit);
			System.out.printf("%s ", question);
			opt = input.nextInt();
			index = 0;
			if(opt > total) continue;
			if(opt == total) break;
			buildMenuInput(opt, items, exit.length > 1 ? exit[1] : "Continue [Enter]");
		}
	}
	
	private void buildMenuCatalog(String question, HashMap<String, MenuCallback> items, String... exit) {
		System.out.println("=============== MENU ============");
		items.forEach((k, v) -> {
			System.out.printf("%d - %s\n", (index + 1), k);
			index++;
		});
		System.out.printf("%d - %s\n", this.total, exit.length > 0 ? exit[0] : "Exit");
		System.out.println("=================================");
	}
	
	private void buildMenuInput(int opt, HashMap<String, MenuCallback> items, String... exit) {
		ArrayList<MenuCallback> callbacks = new ArrayList<MenuCallback>();
		items.forEach((k, v) -> callbacks.add(items.get(k)) );
		if(callbacks.size() != 0) {
			callbacks.get(opt - 1).doSomething();
			System.out.println();
			System.out.print(exit[0]);
			input.nextLine(); input.nextLine();
			System.out.printf("\n\n\n");
		}
		
	}

}