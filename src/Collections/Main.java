package Collections;

public class Main {

	static void RunInput1() {
		Input1.Reader customReader = new Input1.Reader("input.dat");
		System.out.println(customReader.getTotalNumberOfWords());
		customReader.showOccurencies();
		customReader.showDistinctWords();
		customReader.showWordsThatStartWith();
	}

	static void RunInput2() {
		Input2.Reader customReader = new Input2.Reader("input2.dat");
		customReader.showList();
		Input2.Processer processer = new Input2.Processer(customReader.getResults());
		processer.showProcessedResults();
	}

	public static void main(String[] args) {
		// RunInput1();
		RunInput2();
	}

}
