package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BuildMenu {

	public int total = 0;
	private static int index = 0;

	public BuildMenu(String question, HashMap<String, MenuCallback> items) {
		total = items.size();
		Scanner input = new Scanner(System.in);
		int opt = 0;
		while(true) {
			buildMenuCatalog(question, items);
			System.out.printf("%s ", question);
			opt = input.nextInt();
			index = 0;
			if(opt > total) continue;
			buildMenuInput(opt, items);
			
		}
	}
	
	private static void buildMenuCatalog(String question, HashMap<String, MenuCallback> items) {
		System.out.println("=============== MENU ============");
		items.forEach((k, v) -> {
			System.out.printf("%d - %s\n", (index + 1), k);
			index++;
		});
		System.out.println("=================================");
	}
	
	private static void buildMenuInput(int opt, HashMap<String, MenuCallback> items) {
		ArrayList<MenuCallback> callbacks = new ArrayList<MenuCallback>();
		items.forEach((k, v) -> callbacks.add(items.get(k)) );
		if(callbacks.size() != 0) {
			callbacks.get(opt - 1).doSomething();
		}
		
		
	}

}