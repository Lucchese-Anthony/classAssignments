public class parallel extends Thread{
	
	private int beg;
	private int Final;
	static int totalPrimes = 0;
	
	
	public parallel(int start, int End) {
		beg = start;
		Final = End;
	}
	
	public static void main(String[] args) {
		
		parallel thread1 = new parallel(1000000, 1249999);
		thread1.start();
		parallel thread2 = new parallel(1250000, 1499999);
		thread2.start();
		parallel thread3 = new parallel(1500000, 1749999);
		thread3.start();
		parallel thread4 = new parallel(1750000, 2000000);
		thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (Exception e) {}
			System.out.println(totalPrimes + " primes found");
		
		
	}
	
	public void start() {
		int localPrimes = 0;
		for(int i = beg; i <= Final; i++) {
			if (isPrime(i)) {
				totalPrimes++;
				localPrimes++;
			}
		}
		 System.out.println("Primes in local range: " + localPrimes);
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
