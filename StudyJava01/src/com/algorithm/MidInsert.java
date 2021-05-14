package com.algorithm;

/**
 * @author Liutao0705@live.com
 * @date 2019/12/19 9:47 下午
 */

public class MidInsert {
    //数组的基本操作-3：插入元素
    /*
     * 尾部插入
     * 中间插入
     * 超范围插入
     * */

    private int[] array;
    //成员变量size是数组实际元素的数量。
    private int size;

    public MidInsert(int capacity){
        this.array = new int[capacity];
        size = 0;
    }

    /*
    * 数组插入元素
    * @param element 插入的元素
    * @param index   插入的位置
    * */

    public  void insert(int element,int index) throws Exception{
        //判断下标是否超出范围
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }

        //从右到左循环，将元素逐个向右挪一位
        System.out.println("size init = " + size);
        for (int i =size -1;i>index;i--){
            array[i+1] = array[i];
            System.out.println("size = "+size);
            System.out.println("i = "+i);
        }
        //腾出来的位置放入新元素
        array[index] = element;
        size++;

    }

    /*
    *输出数组
    * * */
    public void output(){
        for (int i = 0;i<size;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        MidInsert mi = new MidInsert(10);
        mi.insert(3,0);
        mi.insert(7,1);
        mi.insert(9,2);
        mi.insert(5,3);
        mi.insert(6,1);
        mi.output();
    }

}
