package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    /**
     * This method should return the product of the first n prime numbers
     * @param n
     * @param m
     * @return
     */
    public static int Ifprime(int n){
        if (n <= 1)
            return 0;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return 0;

        return 1;


    }
    public static long getPrimeProduct(int n, int m) {
        long product=1;
        int i=n;
        if(n==1)i=2;

        int k=0;
        while(i<m){
            if(Ifprime(i)==1){
                product*=i;
                System.out.printf(i+" ");
                k++;
            }
            i++;
        }
        return product;
    }


    /**
     * This method should read from the console a number
     * @return the number read from the console
     */
    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
