package OOP;

public class Interface {

	public enum Currency {
		RON, EUR, USD
	}

	public interface InstrumentBancar {
		String getType();

		float getInstrumentValue();

		float getAmount();

		default Currency getCurrency() {
			return Currency.RON;
		}
	}

	public class Actiune implements InstrumentBancar {
		private String m_Type;
		private float m_Value, m_Amount;
		@SuppressWarnings("unused")
		private float m_MarketCap;

		@Override
		public String getType() {
			return m_Type;
		}

		@Override
		public float getInstrumentValue() {
			return m_Value;
		}

		@Override
		public float getAmount() {
			return m_Amount;
		}

		public Actiune(String type, float value, float marketCap, float amount) {
			m_Type = type;
			m_Value = value;
			m_MarketCap = marketCap;
			m_Amount = amount;
		}

	}

	public class Depozit implements InstrumentBancar {
		private String m_Type;
		private float m_Value, m_Amount;
		@SuppressWarnings("unused")
		private final float MAX_DEPOZIT = 999999;
		@SuppressWarnings("unused")
		private Currency m_currency;

		@Override
		public String getType() {
			return m_Type;
		}

		@Override
		public float getInstrumentValue() {
			return m_Value;
		}

		@Override
		public float getAmount() {
			return m_Amount;
		}

		public Depozit(String type, float value, Currency currency) {
			m_Type = type;
			m_Value = value;
			m_currency = currency;
			Add(value);
		}

		public void Add(float val) {
			m_Amount += val;
		}
	}

	public class Cumparator {
		private Depozit m_Deposit = null;
		private Actiune m_Stock = null;

		public Cumparator(int choice, Object[] args) {
			switch (choice) {
			case 0:
				m_Deposit = new Depozit(args[0].toString(), (float) args[1], (Currency) args[2]);
				break;
			case 1:
				m_Stock = new Actiune(args[0].toString(), (float) args[1], (float) args[2], (float) args[3]);
				break;
			default:
				break;
			}

		}

		public String getInfo() {
			String tmp = m_Deposit != null ? m_Deposit.getType() + ":" + m_Deposit.m_Amount + "\n"
					: "depozit inexistent\n";
			tmp += m_Stock != null ? m_Stock.getType() + ":" + m_Stock.getAmount() : "actiune inexistenta";
			return tmp;
		}
	}

}
