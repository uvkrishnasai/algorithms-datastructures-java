package org.practice.programs.beginner;

/**
 * Created by Krishna on 5/22/16.
 */
public class PrimeNumber {

    //mine
    public static void generate(int length) {
        System.out.print("2 3 ");

        for (int i = 4; i < length; i++) {
            if (i%2 == 0 || i%3 == 0)
                continue;
            System.out.print(i + " ");
        }
    }

    //mine
    public static boolean checkWhetherPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if(n <=1 || n%2 == 0 || n%3 == 0)  {
            return false;
        }

        return true;

    }

    //jmse
    public static boolean isPrimeNumber(int n){

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;  //means number wasn't divisible by any of the number, it's a prime number.
    }

    public static void main(String[] args) {
        generate(100);
        int n=11;
        System.out.println(checkWhetherPrime(n)? n+" is prime number." : n+" is not prime number.");
        System.out.println(isPrimeNumber(n)? n+" is prime number." : n+" is not prime number.");
        n=12;
        System.out.println(checkWhetherPrime(n)? n+" is prime number." : n+" is not prime number.");
        System.out.println(isPrimeNumber(n)? n+" is prime number." : n+" is not prime number.");
        n=13;
        System.out.println(checkWhetherPrime(n)? n+" is prime number." : n+" is not prime number.");
        System.out.println(isPrimeNumber(n)? n+" is prime number." : n+" is not prime number.");
        n=14;
        System.out.println(checkWhetherPrime(n)? n+" is prime number." : n+" is not prime number.");
        System.out.println(isPrimeNumber(n)? n+" is prime number." : n+" is not prime number.");
    }

}
