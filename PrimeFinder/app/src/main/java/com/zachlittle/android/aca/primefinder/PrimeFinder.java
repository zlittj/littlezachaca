package com.zachlittle.android.aca.primefinder;

import android.widget.TextView;

/**
 * Created by Zach on 9/2/16.
 */
public class PrimeFinder implements Runnable{

    public long prime;
    public long target;
    public boolean finished = false;
    private Thread runner;
    TextView mTextView;



    PrimeFinder(long inTarget, TextView textView) {
        target = inTarget;
        mTextView = textView;
        if (runner == null){
            runner = new Thread(this);
            runner.start();
        }
    }
    @Override
    public void run() {
        long numPrimes = 0;
        long candidate =2;

        while (candidate < target) {
            if (isPrime(candidate)) {
                numPrimes++;
                prime = candidate;
                mTextView.append("\nPrime Number found: " + candidate);
            }
            candidate++;

        }
        mTextView.append("Number of Primes: " + numPrimes);
        finished = true;

    }

    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i =2; i<=root; i++) {
            if (checkNumber % i ==0) {
                return false;
            }
        }return true;
    }


}
