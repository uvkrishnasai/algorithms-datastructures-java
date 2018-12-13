package datastructures.string;

import java.util.Arrays;

/**
 * Created by Krishna on 5/22/16.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 7, 8, 9, 14, 16, 16, 17, 17, 17};
        Arrays.stream(arr).distinct().forEach(System.out::println);
    }
}
