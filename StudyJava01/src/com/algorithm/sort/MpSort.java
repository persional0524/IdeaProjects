package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Liutao0705@live.com
 * @date 2020/7/8 9:04 下午
 */
public class MpSort {

    /*
    * 冒泡排序第一版
    * */
    public static void sort(int array[]){
        //双层循环进行排序，外部循环控制所有回合，8个元素，循环7次
        for(int i=0;i<array.length-1;i++){
            System.out.println("see i init value : "+i);
            int tmp= 0;
            //内部循环实现每一轮冒泡处理，先进行元素比较，再进行元素交换
            for (int j=0;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }
    /*
     * 冒泡排序第2版
     * */
    public static void sort2(int array[]){
        //有序标记，每一轮的初始值都是true
        boolean isSorted = true;
        for(int i=0;i<array.length-1;i++){
            int tmp= 0;
            //内部循环实现每一轮冒泡处理，先进行元素比较，再进行元素交换
            for (int j=0;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }
    /*
     * 冒泡排序第3版
     * 关键点在于数列有序区的界定。
     * 有序区的长度和轮数是相等的。
     * 实际上，数列真正的有序区可能会大于这个长度。
     * 第5个元素实际上已经属于有序区了，后面的多次元素比较是没有意义的。
     * */
    public static void sort3(int array[]){

        //记录最有一次交换的位置
        int lastExchangeindex = 0;

        //无序数列的边界，每次比较只需比较这里为止
        int sortBorder = array.length -1;
        //有序标记，每一轮的初始值都是true
        boolean isSorted = true;
        for(int i=0;i<array.length-1;i++){
            int tmp= 0;
            //内部循环实现每一轮冒泡处理，先进行元素比较，再进行元素交换
            for (int j=0;j< sortBorder ;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记false
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeindex = j;
                    System.out.println("sortBorder : "+sortBorder);
                }
            }
            //sortBorder 无序数列的边界，每一轮排序，处于sortBorder之后元素
            //就不会进行比较了，肯定有序的。
            sortBorder = lastExchangeindex;

            if (isSorted){
                break;
            }
            System.out.println("see i init value : "+i);
        }
    }
    /*
     * 冒泡排序第4版
     * 鸡尾酒排序
     * 算法的每一轮都是从左到右来比较元素，进行单向的位置交换
     * 鸡尾酒排序的元素比较和交换过程是双向的。
     * 奇数，从左往右
     * 偶数，从右往左
     * */
    public static void sort4(int array[]){
        int tmp = 0;
        for(int i=0;i<array.length/2;i++){
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左往右比较和交换
            for (int j=i; j< array.length-i-1 ;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
             //偶数轮之前，将isSorted重新置为true
            isSorted = true;
            //偶数轮，从左往右比较和交换
            for (int j=array.length-i-1;j>i;j--){
                if(array[j] < array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1]=tmp;
                    //因为有元素进行交换，所以不是有序的，标记false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        bubbleSort_sort5(arr);
        return Arrays.copyOf(arr, k);
    }

    public static void bubbleSort_sort5(int[] arr) {
        boolean swapped = true;
        // 最后一个没有经过排序的元素的下标
        int indexOfLastUnsortedElement = arr.length - 1;
        // 上次发生交换的位置
        int swappedIndex = -1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    // 表示发生了交换
                    swapped = true;
                    // 更新交换的位置
                    swappedIndex = i;
                }
            }
            // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            indexOfLastUnsortedElement = swappedIndex;
        }
    }
    public static void main(String[] args) {
      //int[] arry = new int[]{5,8,6,3,9,2,1,7};
      int[] arry1 = new int[]{2,3,4,5,6,7,8,1};
        //sort(arry);
        //sort2(arry);
        //sort3(arry);
        //sort4(arry1);
        getLeastNumbers(arry1,3);
        System.out.println(Arrays.toString(arry1));
        //System.out.println(Arrays.copyOf(arry1, 3));
    }

    /*
    * 总结：
    * 鸡尾酒排序优点是能够在特定的条件下，减少排序的回合数；
    * 缺点也是很明显，代码量几乎增加一倍。
    * */
}
