package zeckendorf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ZeckendorfUtils {

	public static final BigInteger BigInteger_10 = BigInteger.TEN;

	public static List<Integer> retrieveFibonacciSeqNumbers(int number) {
		List<Integer> fibonacciSeqList = new ArrayList<>();
		int fibonacci = 1;

		if (number == 1 || number == 2) {
			fibonacciSeqList.add(fibonacci);
		} else {
			fibonacciSeqList.add(fibonacci);
			int firstNumber = 1;
			int nextNumber = 1;
			while ((fibonacci = firstNumber + nextNumber) <= number) {
				firstNumber = nextNumber;
				nextNumber = fibonacci;
				fibonacciSeqList.add(fibonacci);

			}
		}
		return fibonacciSeqList;
	}

	public static BigInteger calculateZeckendorfNumber(int number, List<Integer> fibonacciNumbers) {

		int numbersLength = fibonacciNumbers.size() - 1;
		for (Integer value : fibonacciNumbers) {
			if (number >= value) {
				BigInteger bigNr = (numbersLength == 0) ? BigInteger.ONE : BigInteger_10.pow(numbersLength);

				numbersLength--;
				return bigNr.add(calculateZeckendorfNumber(number - value, fibonacciNumbers));
			} else {
				numbersLength--;
			}
		}
		return BigInteger.ZERO;
	}

}
