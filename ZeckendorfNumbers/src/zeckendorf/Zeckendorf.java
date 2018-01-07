package zeckendorf;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zeckendorf {

	public static Map<Integer, BigInteger> retrieveZeckendorfNumbers(BigInteger from, BigInteger to) throws Exception {
		if ((from.intValue() >= 0) && (to.intValue() <= 2147483647) && (from.intValue() < to.intValue())) {

			List<Integer> fibSeqNumbers = ZeckendorfUtils.retrieveFibonacciSeqNumbers(to.intValue());
			Collections.reverse(fibSeqNumbers);
			Map<Integer, BigInteger> zeckendorfNumbers = new HashMap<>();

			for (int i = from.intValue() + 1; i < to.intValue(); i++) {
				zeckendorfNumbers.put(i, ZeckendorfUtils.calculateZeckendorfNumber(i, fibSeqNumbers));
			}
			return zeckendorfNumbers;
		} else
			throw new Exception(" The interval numbers must be between 0 and 2,147,483,647 ");
	}

	public static void main(String... args) {

		Map<Integer, BigInteger> zeckendorfNumbers;
		try {
			zeckendorfNumbers = retrieveZeckendorfNumbers(new BigInteger("4"), new BigInteger("36754"));

			zeckendorfNumbers.forEach((k, v) -> {
				System.out.println("Number : " + k + " has Zeckendorf number : " + v);

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
