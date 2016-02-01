package atdd9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
	public static String DELIMITERS="[,;|n\\s]";
	public static int add(final String numbers) {
		String delimiter = ",|n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers
					.substring(numbers.indexOf("n") + 1);
		}
		return add(numbersWithoutDelimiter, delimiter);
	}

	public static int new_add(final String numbers) {
		Scanner input = new Scanner(numbers);
		input.useDelimiter(StringCalculator.DELIMITERS);
		List<String> ll=new LinkedList<String>();
		while (input.hasNext())
			ll.add(input.next());
		return new_add(ll.toArray(new String[0]));
	}

	private static int new_add(final String[] numbers) {
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

	private static int add(final String numbers, final String delimiter) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(delimiter);
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number.trim());
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
