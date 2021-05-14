package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Liutao0705@live.com
 * @date 2020/7/9 11:43 下午
 */
public class quicksort {

    public static void quickSork(int[] arr,int startIndex,int endIndex){
        //递归的结束条件，startIdex>=int endIndex
        if(startIndex >= endIndex){
            return;
        }
        //得到基准元素位置
        //int pivotIndex =partition(arr,startIndex,endIndex);
        int pivotIndex =partitionv2(arr,startIndex,endIndex);
        //根据基准元素，分成两个部分进行递归
        quickSork(arr,startIndex,pivotIndex-1);
        quickSork(arr,pivotIndex+1,endIndex);
    }
    /**
     * 分治（双边循环法）
     * @param arr         待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while(left != right){
            //控制right指针比较并左移
            while(left < right && arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            while(left < right && arr[left] <= pivot){
                left++;
            }
            //交换left和right指针所指向的元素
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }
    private static int partitionv2(int[] arr, int startIndex, int endIndex) {
        //选取第一个位置为基准元素（可以选择随机位置）
        int pivot =arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1;i<=endIndex;i++){
            if(arr[i] < pivot){
                mark++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,4,6,5,3,2,8,1};
        quickSork(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
