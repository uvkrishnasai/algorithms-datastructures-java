package datastructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Given five positive integers,
 * find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * For example, arr = [1,3,5,7,9].
 * Our minimum sum is 1+3+5+7=16 and
 * our maximum sum is 3+5+7+9=24.
 *
 * We would print
 * 16 24
 *
 * Link: https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MiniMaxiSum {

    static void miniMaxSum(int[] arr) {

        List<Integer> numbers = new ArrayList<>();
        for(int n : arr) {
            numbers.add(new Integer(n));
        }

        TreeSet<Long> sortedSums = new TreeSet<>();
        for(Integer number : numbers) {

            List<Integer> numbersToBeAdded = new ArrayList<>(numbers);
            numbersToBeAdded.remove(number);
            sortedSums.add(findSum(numbersToBeAdded));

        }

        Long[] sortedSumsArray = sortedSums.toArray(new Long[sortedSums.size()]);
        System.out.println(sortedSumsArray[0] + " " + sortedSumsArray[sortedSumsArray.length-1]);

    }

    private static Long findSum(List<Integer> numbers) {
        Long num = 0L;
        for (Integer i : numbers) {
            num= num + i;
        }
        return num;
    }
}
