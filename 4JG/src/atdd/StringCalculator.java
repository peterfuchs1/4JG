package atdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
	public static String DELIMITERS="[,;|n\\s]";
	public static int add(final String numbers) {
		Scanner input = new Scanner(numbers);
		input.useDelimiter(StringCalculator.DELIMITERS);
		List<String> ll=new LinkedList<String>();
		while (input.hasNext())
			ll.add(input.next());
		return add(ll.toArray(new String[0]));
	}

	private static int add(final String[] numbers) {
		int returnValue = 0;
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (!numbers[i].trim().isEmpty()) {
				int numberInt = Integer.parseInt(numbers[i].trim());
				if (numberInt < 0) {
					negativeNumbers.add(numberInt);
				} else if (numberInt <= 1000) {
					returnValue += numberInt;
				}
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: "
					+ negativeNumbers.toString());
		}
		return returnValue;
	}

}
