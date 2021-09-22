public class serial{
	
	public static void main(String[] args) {
		int first = 1000000;
		int last = 2000000;
		
		basicPrime(first, last);
		
	}
	
	public static void basicPrime(int start, int end) {
		int counter = start;
		int primeNumber = 0;
		while(counter <= end) {
			if(isPrime(counter)) {
				primeNumber++;
			}
			counter++;
		}
		System.out.println(primeNumber + " primes found.");
	}
	
	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		} 
		return true;
	}
	
}
