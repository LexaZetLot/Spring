package org.example.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Margesort<T> implements Sort<T>{
    @Autowired
    @Qualifier("buf")
    Buf buf;
    Comparison margesort_comparison;

    public void setmargesort_comparison(Comparison comparison) {
        this.margesort_comparison = comparison;
    }

    public void sort(T[] arr){
        buf.gg();
        merge_recursion(arr, 0, arr.length - 1);
    }

    private void merge_recursion(T[] arr, int left, int right){
        if(left < right){
            int middle = left + (right - left) / 2;

            merge_recursion(arr, left, middle);
            merge_recursion(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(T[] arr, int left, int middle, int right){
        int left_size = middle - left + 1;
        int right_size = right - middle;
        T[] arr_left = (T[]) new Object[left_size];
        T[] arr_right = (T[]) new Object[right_size];

        for(int i = 0; i < left_size; i++)
            arr_left[i] = arr[left + i];
        for(int i = 0; i < right_size; i++)
            arr_right[i] = arr[middle + 1 + i];

        for (int i = 0, j = 0, k = left; k <= right; k++){
            if((i < left_size) && ((j >= right_size) || margesort_comparison.comparison(arr_left[i], arr_right[j]))){
                arr[k] = arr_left[i];
                i++;
            }else {
                arr[k] = arr_right[j];
                j++;
            }
        }
    }
}
