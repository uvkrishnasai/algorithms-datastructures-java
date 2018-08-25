package datastructures.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna on 5/22/16.
 *
 * Find only duplicate number in given list, assuming there is only one
 *
 * find duplicate digits in a number:TBD
 *
 * Find all duplicate numbers in a list
 *
 */
public class DuplicateNumber {

    //From JMSE
    public static int findDuplicate(int highestNumberInList, int duplicateNumber){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=highestNumberInList;i++){
            list.add(i);
        }
        list.add(duplicateNumber);


        int sumOfNums = 0;
        for (int n:list) {
            sumOfNums += n;
        }

        //Arithmetic Progression n*(n+1)/2 where n = highestNum
        return (sumOfNums - ((highestNumberInList) * (highestNumberInList+1)/2));

    }

    public static List<Integer> findAllDuplicate(int highestNumberInList, List<Integer> duplicateNumberList){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=highestNumberInList;i++){
            list.add(i);
        }
        list.addAll(duplicateNumberList);

        List<Integer> nonDuplicate = new ArrayList<>();
        List<Integer> duplicate = new ArrayList<>();


        int sumOfNums = 0;
        for (int n:list) {
            if (nonDuplicate.contains(n))
                duplicate.add(n);
            else
                nonDuplicate.add(n);
        }

        //Arithmetic Progression n*(n+1)/2 where n = highestNum
        return duplicate;

    }

    public static void main(String[] args) {
//        System.out.println(findDuplicate(10, 9));

        List<Integer> duplicateNumList = new ArrayList<>();
        duplicateNumList.add(6);
        duplicateNumList.add(7);
        duplicateNumList.add(10);

        List<Integer> duplicates = findAllDuplicate(10, duplicateNumList);
        for (int n:duplicates) {
            System.out.print(n + " ");
        }

    }


}
