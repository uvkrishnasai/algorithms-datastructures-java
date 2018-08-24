package org.practice.programs.beginner;

/**
 * Created by Krishna on 5/22/16.
 *
 * Swap two variables without using third variable
 */
public class Swap {

    // Mine == JMSE
    public static void swap(int a, int b) {

        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        swap(200, 300);
    }

}
