package org.example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Insertionsort<T> implements Sort<T>{
    @Autowired
    @Qualifier("buf")
    Buf buf;
    Comparison insertionsort_comparison;

    public void setinsertionsort_comparison(Comparison comparison) {
        this.insertionsort_comparison = comparison;
    }
    @Override
    public void sort(T[] arr){
        buf.gg();
        int i;
        int j;
        T key;

        for(i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;
            while (j >= 0 && insertionsort_comparison.comparison(arr[j], key)){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
