package datastructures.string;

/**
 * Created by Krishna on 5/22/16.
 */
public class RemoveDuplicates<T extends Comparable> {


    //Mine incomplete solution
    public void remove(T[] tArray) {



        int i = 0;
        int j = 1;

        while (j <= tArray.length) {

            T t1 = tArray[i];
            T t2 = tArray[j];

            if (t1.compareTo(t2) > 0) {
                break;
            }

            if (t1 == t2) {
                for (int k = j; k < tArray.length-1; k++) {
                    swap(tArray, k , k+1);
                }
            }else{
                i++;
                j++;
            }
        }

        for (int k = 0; k <= i+1; k++) {
            System.out.print(tArray[k]+ " ");
        }

    }

    public void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //JMSE Solution
    public static int[] removeDuplicates(int[] duplicateSortedAr){

        int i=0, j=1;

        if(duplicateSortedAr.length < 2){ //means there is only one element in array.
            return duplicateSortedAr;
        }

        while(j < duplicateSortedAr.length){
            if(duplicateSortedAr[j] == duplicateSortedAr[i])
                j++;
            else
                duplicateSortedAr[++i] = duplicateSortedAr[j++];
        }

        int[] nonDuplicateSortedAr = new int[i+1];
        for(int x=0; x<nonDuplicateSortedAr.length; x++){
            nonDuplicateSortedAr[x] = duplicateSortedAr[x];
        }

        return nonDuplicateSortedAr;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 3, 7, 8, 9, 14, 16, 16, 17, 17, 17};
        Character[] charArray = {'C', 'F', 'S', 'S', 'D'};

        RemoveDuplicates<Integer> intrd = new RemoveDuplicates<>();
        intrd.remove(intArray);

        RemoveDuplicates<Character> charrd = new RemoveDuplicates<>();
        charrd.remove(charArray);
    }

}
