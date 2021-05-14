package com.algorithm.sort;

import java.util.Arrays;

public class insert_sort {

    public static void insert_sort_v1(int array[],int length){
       int temp;
        for (int i = 0; i < array.length-1; i++) {
            System.out.println("iii="+i);
            for (int j = i+1; j >0 ; j--) {
                System.out.println("j="+j);
                if (array[j]<array[j-1]) {
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,4,6,5,3,2,8,1};
        insert_sort_v1(arr,7);
        System.out.println(Arrays.toString(arr));
    }
}
