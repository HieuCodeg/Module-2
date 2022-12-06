package so_nguyen_to;

public class Test {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization("Lazy");
        OptimizedPrimeFactorization opti = new OptimizedPrimeFactorization("Opty");

        Thread th1 = new Thread(lazy);
        Thread th2 = new Thread(opti);

        th1.start();
        th2.start();
    }
}
