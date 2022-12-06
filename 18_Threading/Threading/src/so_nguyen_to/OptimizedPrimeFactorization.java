package so_nguyen_to;

public class OptimizedPrimeFactorization implements Runnable{
    private String name;

    public OptimizedPrimeFactorization(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int number = 1;
        boolean isPrime;
        while (true) {
            number++;
            isPrime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(name + "print: " + number);
            }

        }
    }
}
