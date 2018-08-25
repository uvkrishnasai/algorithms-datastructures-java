package datastructures.math;

/**
 * Created by Krishna on 6/11/16.
 */
public class IndexLeftSumEqualRight {

    //mine
    public static int findIndex(int num) {

        if(num <= 0)
            return -1;

        int totalSum = 0;
        int length = 0;
        int givenNum = num;

        while(givenNum>9) {
            totalSum += givenNum%10;
            givenNum /= 10;
            length++;
        }
        totalSum += givenNum;
        length++;

        int rightSum = 0;
        int digit = 0;
        for (int i = 1; i <= length; i++) {
            digit = num%10;
            num /= 10;

            rightSum += digit;
            totalSum -= digit;

            if(totalSum == rightSum) {
                return length-i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findIndex(24411));
        System.out.println(findIndex(2114));
        System.out.println(findIndex(211224));
        System.out.println(findIndex(2411));
    }

}
