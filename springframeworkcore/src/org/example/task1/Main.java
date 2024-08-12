package org.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Random random = new Random();
        Sort<Long> insertionsort = ctx.getBean("insertionsort", Insertionsort.class);
        Sort<Integer> margesort = ctx.getBean("margesort", Margesort.class);
        int size = 10000;
        int max_int = 10000;
        Long[] arr_long = new Long[size];
        Integer[] arr_int = new Integer[size];
        for(int i = 0; i < size; i++)
            arr_long[i] = random.nextLong(max_int);
        for(int i = 0; i < size; i++)
            arr_int[i] = random.nextInt(max_int);

        for(int i = 0; i < size; i++)
            System.out.print(arr_long[i] + " ");

        insertionsort.sort(arr_long);

        System.out.println(" ");
        for(int i = 0; i < size; i++)
            System.out.print(arr_long[i] + " ");

        System.out.println(" ");
        for(int i = 0; i < size; i++)
            System.out.print(arr_int[i] + " ");

        margesort.sort(arr_int);

        System.out.println(" ");
        for(int i = 0; i < size; i++)
            System.out.print(arr_int[i] + " ");
    }
}
