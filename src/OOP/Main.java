package OOP;

import java.util.Scanner;

import OOP.Interface.Cumparator;
import OOP.Interface.Currency;

public class Main {

	static void runAbstractClass() {
		AbstractClass.ComandaFactory c = null;

		System.out.println("0 - Comanda Ferma");
		System.out.println("1 - Comanda Magazin");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 0:
			c = new AbstractClass().new ComandaFerma();
			c.processCommand();
			c.payMerchant(AbstractClass.TipPersoanaFinanciara.Fizica, "FFF667", 999);
			c.checkMerchant();
			break;
		case 1:
			c = new AbstractClass().new ComandaMagazin();
			c.processCommand();
			c.payMerchant(AbstractClass.TipPersoanaFinanciara.Juridica, "JJJ654", 1234);
			c.checkMerchant();
			break;
		default:
			break;
		}
	}

	static void runInterface() {
		System.out.println("0 - Depozit");
		System.out.println("1 - Actiune");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		Cumparator cumparator = null;
		switch (choice) {
		case 0:
			cumparator = new Interface().new Cumparator(choice, new Object[] { "BRD", 1000.0f, Currency.RON });
			break;

		case 1:
			cumparator = new Interface().new Cumparator(choice, new Object[] { "BRD", 1000.0f, 1255534f, 199f });
			break;
		default:
			break;
		}

		if (cumparator != null)
			System.out.println(cumparator.getInfo());
	}

	public static void main(String[] args) {

		 runAbstractClass();
		//runInterface();
	}

}
