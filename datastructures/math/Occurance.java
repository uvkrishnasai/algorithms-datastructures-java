package org.practice.programs.beginner;

import java.math.BigInteger;

/**
 * Created by Krishna on 5/22/16.
 */
public class Occurance {

    //Mine
    public static int findOccurance(BigInteger num1, int num2) {
        int counter = 0;
        while (num1.compareTo(BigInteger.valueOf(0L))>0) {
            if(num1.mod(BigInteger.valueOf(10L)).intValue() == num2)
                counter++;
            num1 = num1.divide(BigInteger.valueOf(10L));
        }
        return counter;
    }

    //JMSE
    public static int calculateOccurrenceOf(long num,int occurrenceOf){
        long cubeOfNumber=num*num*num;
        int count=0;

        while(cubeOfNumber>0){
            if(cubeOfNumber%10==occurrenceOf){
                count++;
            }
            cubeOfNumber=cubeOfNumber/10;
        }
        return count;
    }

    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf (1551L);
        BigInteger nCube = num.pow(3);
        System.out.println(findOccurance(nCube, 1));
        System.out.println(calculateOccurrenceOf(1551L, 1));
    }


}
