package org.practice.programs.beginner;

/**
 * Created by Krishna on 6/11/16.
 */
public class PerfectNumber {

    public static boolean isNumberPerfect(int num) {

        int sumOfDigits = 1;
        for (int i = 2; i <= num/2; i++) {
            if (num%i == 0)
                sumOfDigits += i;
        }

        if(sumOfDigits == num)
            return true;


        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumberPerfect(6));
        System.out.println(isNumberPerfect(28));
        System.out.println(isNumberPerfect(496));
    }

}
