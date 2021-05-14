package com.algorithm.sort;

import java.util.Arrays;

/**
 *
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 *
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 *
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 *
 * 4.重复步骤 3 直到某一指针达到序列尾；
 *
 * 5.将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 * **/

public class MergeSort_v1 {

    public static void main(String [] args) {
      int [] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
     public static void sort(int[] arr){
        int[] temp = new int[arr.length];//排序前，先建立好一个长度等于原数组长度的临时数组。避免递归中频繁开辟空间。
         sort(arr,0,arr.length-1,temp);
     }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组的指针

        while (i<mid && j<=right){
            if (arr[i] <= arr[j]) {
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
            }
        }

            while(i<=mid){
                temp[t++]=arr[i++];//将左边剩余元素填充进temp中
            }
            while(j<=right){
                temp[t++]=arr[j++];//将右序列剩余元素填充进temp中
            }
            t = 0;
            while(left <=right){
                arr[left++]=temp[t++];//将temp中的元素全部拷贝到原数组中
            }
        }



}
