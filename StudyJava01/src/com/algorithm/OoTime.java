package com.algorithm;

/**
 * @author Liutao0705@live.com
 * @date 2019/12/18 9:18 下午
 */
public class OoTime {

    /**
     * 场景一：T（n）= 3n，执行次数是线性的
     */

    public static void eat1 (int n){
        for (int i=0;i<n;i++){
            System.out.println("等待一分钟");
            System.out.println("等待一分钟");
            System.out.println("吃一厘米面包");

        }
    }

    /**
     * 场景 2
     * T(n) = 5log n，执行次数是用 对数 计算的。
     */

    void eat2(int n){
        for(int i=n; i>1; i/=2){
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("等待1分钟");
            System.out.println("吃一半面包");
        }
    }
    /**
     * 场景 3
     * T(n) = 2，执行次数是 常量。
     */
    void eat3(int n){
        System.out.println("等待1分钟");
        System.out.println("吃1个鸡腿");
    }

    void eat4(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.println("等待1分钟");
            }
            System.out.println("吃1cm面包");
        }
    }

    /**
     * 场景 4
     * T(n) = 0.5n2+0.5n，执行次数是用 多项式 计算的。
     */
    public static void main(String[] args) {
        eat1(3);
        //数组的基本操作-1：读取元素
        int[] array = new int[]{3,1,2,5,4,9,7,2};
        //输出数组中下标为3的元素 :5
        System.out.println("输出数组中下标为3的元素 = "+array[3]);
        //数组的基本操作-2：更新元素
        array[3] = 6 ;
        System.out.println("new array[3] = " +array[3]);
        System.out.println("数组读取元素和更新元素的时间复杂度都是O(1)");

    }
}
