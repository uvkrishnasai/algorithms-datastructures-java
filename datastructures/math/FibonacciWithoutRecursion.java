package org.practice.programs.beginner;

/**
 * Created by Krishna on 5/22/16.
 */
public class FibonacciWithoutRecursion {

    //Mine
    public void generate(int length) {
        int[] fibonacci = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == 1) {
                fibonacci[i] = i;
            }else
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
            System.out.print(fibonacci[i] + " ");
        }
    }

    //JMSE
    public static void generateJMSE(int n){
        int first=0;  //first number of series
        int second=1; //second number of series
        int temp;

        System.out.print("FibonacciSeries: "+ first+" "+second+" ");
        for(int i=0;i<n;i++){
            temp=first+second;
            first=second;
            second=temp;
            System.out.print(temp+" ");
        }
    }

    public static void main(String[] args) {
        FibonacciWithoutRecursion fwr = new FibonacciWithoutRecursion();
        fwr.generate(10);
    }

}
