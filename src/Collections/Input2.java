package Collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Input2 {

	static public class Processer {
		private double m_TotalSum;
		private int m_IDMaxVal, m_IDMinVal;

		public Processer(LinkedList<Comanda> list) {
			Process(list);
		}

		public double getTotalSum() {
			return m_TotalSum;
		}

		public int getMinValID() {
			return m_IDMinVal;
		}

		public int getMaxValID() {
			return m_IDMaxVal;
		}

		public void Process(LinkedList<Comanda> list) {
			double minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
			int indexMin = -1, indexMax = -1, index = 0;
			for (Comanda comanda : list) {
				double value = comanda.m_Price * comanda.m_Quantity;
				m_TotalSum += value;
				if (value < minVal) {
					indexMin = index;
					minVal = value;
				}
				if (value > maxVal) {
					indexMax = index;
					maxVal = value;
				}
				++index;
			}
			m_IDMaxVal = indexMax;
			m_IDMinVal = indexMin;
		}

		public void showProcessedResults() {
			System.out.println("Suma totala aferenta tuturor comenzilor: " + getTotalSum());
			System.out.println("ID-ul comenzii cu cea mai mare valoare: " + getMaxValID());
			System.out.println("ID-ul comenzii cu cea mai mica valoare: " + getMinValID());
		}
	}

	static public class Comanda {
		private int m_ID, m_Quantity;
		private double m_Price;

		public Comanda(int ID, double Price, int Quantity) {
			this.m_Price = Price;
			this.m_ID = ID;
			this.m_Quantity = Quantity;
		}
	}

	static public class Reader {
		String m_FileName;
		LinkedList<Comanda> m_LinkedList;
		final String PATH = "\\src\\Collections\\";

		public Reader(String filename) {
			m_FileName = filename;
			readFile();
		}

		LinkedList<Comanda> getResults() {
			return m_LinkedList;
		}

		void readFile() {
			BufferedReader reader = null;
			m_LinkedList = new LinkedList<Comanda>();
			try {
				final String workingDir = System.getProperty("user.dir");
				File file = new File(workingDir + PATH + m_FileName);
				reader = new BufferedReader(new FileReader(file));

				String line;
				while ((line = reader.readLine()) != null) {
					String[] words = line.split(" ");
					m_LinkedList.add(new Comanda(Integer.parseInt(words[0]), Double.parseDouble(words[1]),
							Integer.parseInt(words[2])));
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		void showList() {
			if (m_LinkedList.size() > 0)
				for (Comanda comanda : m_LinkedList) {
					System.out.println(
							"ID: " + comanda.m_ID + " Pret: " + comanda.m_Price + " Cantitate: " + comanda.m_Quantity);
				}
		}
	}
}
