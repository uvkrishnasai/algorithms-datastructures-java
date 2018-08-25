package datastructures.math;

/**
 * Created by Krishna on 5/22/16.
 */
public class Factorial {

    //mine
    public static int findFactorial(int num) {
        int fac = 1;
        for (int i = 1; i <= num; i++) {
            fac *= i;
        }
        return fac;
    }

    //JMSE
    public static int findFactorail(int num){
        int factorial=1;
        while(num>0){
            factorial=factorial*num;
            num--;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(findFactorial(10));
        System.out.println(findFactorail(10));
    }

}
