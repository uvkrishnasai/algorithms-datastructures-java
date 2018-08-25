package datastructures.math;

/**
 * Created by Krishna on 5/22/16.
 */
public class SumOfDigits {

    //Same with JMSE
    public static int findSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findSum(325));

    }

}
