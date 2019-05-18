import java.math.BigInteger;

public class FactorialSum{
	
	
	public static void sumFactorial(int n) {
		//Instantiates a BigInteger called fact with a value of 1
		BigInteger fact = new BigInteger("1");
		//Iterates over fact n number of times until fact is equal to n!
		for(int i=1;i<=n;i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		//Prints the factorial value of n
		System.out.println(fact);
		
		int sum = 0;
		BigInteger remainder;
		//While fact is greater than 1
		while (fact.compareTo(BigInteger.valueOf(1))==1) {
			//Stores the value of fact % 10, isolating the right most integer
			remainder = fact.remainder(BigInteger.valueOf(10));
			//Adds remainder to sum
			sum += remainder.intValue();
			//Removes remainder from fact
			fact = fact.subtract(remainder);
			//Divides fact by 10 so the next integer can be isolated
			fact = fact.divide(BigInteger.valueOf(10));
			//System.out.println(sum);
		}
		System.out.println("The sum of the digits in " + n + "! is: " + sum);
	}
	
	public static void main(String args[]) {
		sumFactorial(10);
		sumFactorial(100);
		
		
	}
}