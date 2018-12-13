package datastructures.set;

import java.util.Arrays;

public class HashSet {

private int[] elements;
    private int noOfElems;

    public HashSet() {
        elements = new int[2];
        noOfElems = 0;
    }

    public int size() {
        return noOfElems;
    }

    public boolean add(int element) {

        if (contains(element))
            return false;

        if (noOfElems == elements.length)
            elements = Arrays.copyOf(elements, noOfElems * 2);

        elements[noOfElems++] = element;
        return true;
    }

    public boolean remove(int element) {
        int i = getIndicator(element);

        if (i < noOfElems) {
            i++;
            while (i < noOfElems) {
                elements[i-1] = i;
                i++;
            }

            noOfElems--;
            return true;
        }

        return false;
    }

    public boolean contains(int element) {
        int i = getIndicator(element);
        return i < noOfElems;
    }

    private int getIndicator(int element) {
        int i = 0;
        for (; i < noOfElems; i++) {
            if (elements[i] ==  element) {
                break;
            }
        }
        return i;
    }

}
