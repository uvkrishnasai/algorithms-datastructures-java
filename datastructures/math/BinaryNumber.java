package org.practice.programs.beginner;

/**
 * Created by Krishna on 5/22/16.
 */
public class BinaryNumber {

    //mine
    public static boolean isBinary(int n) {
        while(n > 0) {
            System.out.println(n + " " +n%10);
            if (n%10 == 0 || n%10 == 1){
                n /= 10;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    //JMSE
    public static boolean isBinaryNumber(int n){
        while(n != 0){
            if(n%10 > 1){
                return false;  //number containing any digit greater than 1 means its not binary.
            }
            n = n/10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBinary(10010101));
        System.out.println(isBinaryNumber(10010101));
    }
}
