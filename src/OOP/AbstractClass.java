package OOP;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractClass {
	public enum TipPersoanaFinanciara {
		Fizica, Juridica
	}

	public abstract class Chitanta {
		private float m_Amount;
		private String m_Date;
		protected TipPersoanaFinanciara m_Type;

		public float getAmount() {
			return m_Amount;
		}

		public String getDate() {
			return m_Date;
		}

		public String getType() {
			return m_Type.toString();
		}

		public String getInfo() {
			return "Chitanta pe Persoana " + getType() + " in valoare de " + getAmount()
					+ " a fost achitata in data de " + getDate();
		}

		public void informInvoice() {
			System.out.println("Chitanta a fost trimisa pe Persoana " + getType());
		}

		public Chitanta(float amount) {
			m_Amount = amount;
			m_Date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			System.out.println("O noua chitanta este in curs de efectuare.");
		}
	}

	public class ChitantaFirma extends Chitanta {
		@SuppressWarnings("unused")
		private String m_CUI;

		public ChitantaFirma(String CUI, float amount) {
			super(amount);
			m_CUI = CUI;
			m_Type = TipPersoanaFinanciara.Juridica;
			informInvoice();
		}

	}

	public class ChitantaPersoana extends Chitanta {
		@SuppressWarnings("unused")
		private String m_CNP;

		public ChitantaPersoana(String CNP, float amount) {
			super(amount);
			m_CNP = CNP;
			m_Type = TipPersoanaFinanciara.Fizica;
			informInvoice();
		}

	}

	public abstract class ComandaFactory {
		private String m_Type;
		@SuppressWarnings("unused")
		private boolean m_Processed = false;
		private Chitanta m_Invoice;

		public String getType() {
			return m_Type;
		}

		public void processCommand() {
			m_Processed = true;
		}

		public void payMerchant(TipPersoanaFinanciara type, String id, float amount) {
			if (type == TipPersoanaFinanciara.Juridica)
				m_Invoice = new ChitantaFirma(id, amount);
			else
				m_Invoice = new ChitantaPersoana(id, amount);
		}

		public void checkMerchant() {
			System.out.println(m_Invoice.getInfo());
		}

		public ComandaFactory(String type) {
			m_Type = type;
			System.out.println("O noua comanda este in curs de efectuare.");
		}
	}

	public class ComandaFerma extends ComandaFactory {
		public ComandaFerma() {
			super("Ferma");
			System.out.println("Comanda este de tip " + getType());
		}

		public void processCommand() {
			super.processCommand();
			System.out.println("Comanda de tip " + getType() + " s-a efectuat!");
		}
	}

	public class ComandaMagazin extends ComandaFactory {
		public ComandaMagazin() {
			super("Magazin");
			System.out.println("Comanda este de tip " + getType());
		}

		public void processCommand() {
			super.processCommand();
			System.out.println("Comanda de tip " + getType() + " s-a efectuat!");
		}

	}
}
