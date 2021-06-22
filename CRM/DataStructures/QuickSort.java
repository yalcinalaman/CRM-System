package DataStructures;

import src.Admin;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(List<T> array){
        quickSort(array, 0 , array.size() - 1);

    }

    private static <T extends Comparable<T>> void quickSort(List<T> array , int start , int end){
        if(end - start < 2) return;

        int pivotIndex = partition(array, start , end);
        quickSort(array , start , pivotIndex);
        quickSort(array , pivotIndex+1, end);
    }

    private static <T extends Comparable<T>> int partition(List<T> array , int start , int end){
        T pivot = array.get(start);
        int i = start;
        int j = end;

        while( i < j){

            while(i < j && array.get(--j).compareTo(pivot) >= 0);
            if(i < j) array.set(i,array.get(j));

            while(i < j && array.get(++i).compareTo(pivot) <= 0);
            if(i < j) array.set(j,array.get(i));

        }
        array.set(j,pivot);
        return j;
    }

}
