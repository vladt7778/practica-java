package Collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Input1 {

	static public class Reader {
		
		private List<String> m_Lines = new ArrayList<>();
		private String m_FileName, m_StartWithString;
		private Map<String, Integer> m_wordsOccurency = new HashMap<String, Integer>();
		private Set<String> m_UniqueWords = new TreeSet<String>();
		private int m_TotalWords;
		private final String PATH = "\\src\\Collections\\";
		private boolean m_Read = false;

		public Reader(String filename) {
			m_FileName = filename;
			readFile();
			doCalculations();
		}

		public void showWordsThatStartWith() {
			System.out.println("-");
			for (String string : m_Lines) {
				String[] words = string.split(" ");
				for(String word : words )
				{
					if (word.startsWith(m_StartWithString)) {
						System.out.println(word);
					}
				}
			}
		}

		public void showDistinctWords() {
			for (String word : m_UniqueWords) {
				System.out.println(word);
			}
		}

		public int getTotalNumberOfWords() {
			return m_TotalWords;
		}

		public void showOccurencies() {
			for (Entry<String, Integer> entry : m_wordsOccurency.entrySet())
				System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		void readFile() {
			BufferedReader reader = null;

			try {
				final String workingDir = System.getProperty("user.dir");
				File file = new File(workingDir + PATH + m_FileName);
				reader = new BufferedReader(new FileReader(file));

				String line;
				while ((line = reader.readLine()) != null) {
					if(!m_Read)
					{
						m_Read = true;
						m_StartWithString = line;
						continue;
					}
					m_Lines.add(line);
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

		void doCalculations() {
			for (String string : m_Lines) {
				String[] words = string.split(" ");
				m_TotalWords += words.length;
				for (String word : words) {
					Integer occurrency = m_wordsOccurency.get(word);
					if (occurrency == null)
						m_wordsOccurency.put(word, 1);
					else
						m_wordsOccurency.put(word, occurrency + 1);
				}
			}

			m_UniqueWords = m_wordsOccurency.keySet();
		}
	}
}
