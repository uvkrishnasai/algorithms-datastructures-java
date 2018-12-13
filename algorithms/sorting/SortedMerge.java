package algorithms.sorting;

/**
 * Cracking the coding interview: 10.1
 * Sorted merge - Given 2 sorted arrays A and B
 * Write a method to merge B into A
 * Assumption: A has a enough buffer at the end to accommodate B
 */
public class SortedMerge {

    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 3; A[1] = 4; A[2] = 7; A[3] = 11; A[4] = 25;
        int[] B = new int[] {1, 4, 5, 8, 11};
        
        merge(A, B);

        assert A[0] == 1;
        assert A[1] == 3;
        assert A[2] == 4;
        assert A[3] == 4;
        assert A[4] == 5;
        assert A[5] == 7;
        assert A[6] == 8;
        assert A[7] == 11;
        assert A[8] == 11;
        assert A[9] == 25;
    }

    private static void merge(int[] A, int[] B) {
        if (A == null || A.length == 0)
            return;

        if (B == null || B.length == 0)
            return;

        int i = A.length-B.length-1;
        int j = B.length-1;
        int k = A.length-1;

        while (i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
            k--;
        }

        while (i >= 0) {
            A[k] = A[i];
            i--;
        }

        while (j >= 0) {
            A[k] = B[j];
            j--;
        }
    }
}
