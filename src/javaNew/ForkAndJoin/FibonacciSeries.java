package javaNew.ForkAndJoin;

import java.util.concurrent.RecursiveTask;

public class FibonacciSeries extends RecursiveTask<Integer> {

    int n ;

    public FibonacciSeries(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if (n <= 1) {
            return n;
        }

        FibonacciSeries fin1 = new FibonacciSeries(n - 1);
        fin1.fork();
        FibonacciSeries fin2 = new FibonacciSeries(n - 2);
        fin2.fork();

        return fin1.join() + fin2.join();

    }

    public static void main(String args[]) {
        FibonacciSeries series = new FibonacciSeries(5);
        int sum = series.compute();

        System.out.println("series sum = " + sum);

    }
}
