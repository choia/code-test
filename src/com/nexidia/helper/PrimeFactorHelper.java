package com.nexidia.helper;
import java.util.ArrayList;
import java.util.List;


public class PrimeFactorHelper
{
    /**
     * Method that calculates prime factors of an integer.
     * @param n
     * @return
     */

    public List<Integer> calculatePrimeFactors(int n)
    {
        int number = Math.abs(n);
        List<Integer> primeFactors = new ArrayList<>();

        for (int i = 2; i <= number; i++)
        {
            if (number % i == 0)
            {
                primeFactors.add(i);
                number /= i;
                i--;
            }
        }
        return primeFactors;
    }

    /**
     * Method to print integer from the file and list of prime factors integers.
     * @param primeFactors
     * @param n
     */

    public void displayPrimeFactors(List<Integer> primeFactors, int n)
    {
        System.out.print(n + ": ");
        for (Integer i:primeFactors)
        {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
