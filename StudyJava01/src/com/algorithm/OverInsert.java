package com.algorithm;

/**
 * @author Liutao0705@live.com
 * @date 2019/12/23 10:49 下午
 */
public class OverInsert {

    //数组的基本操作-3：插入元素
    /*
     * 尾部插入
     * 中间插入
     * 超范围插入
     * */

    private int[] array;
    //成员变量size是数组实际元素的数量。
    private int size;

    public OverInsert(int capacity){
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
        //如果实际元素达到数组容量上限，则对数组进行扩容
        if (size>array.length){
            resize();
        }
        //从右到左循环，将元素逐个向右挪一位
        for (int i =size -1;i>index;i--){
            array[i+1] = array[i];
        }
        //腾出来的位置放入新元素
        array[index] = element;
        size++;

    }
    /*
     * 数组扩容
     * */
    private void resize() {
        int[] arrayNew = new int[array.length*2];
        //从旧数组复制到新数组
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }
    /*
     *输出数组
     * * */
    public void output(){
        for (int i = 0;i<size;i++){
            System.out.println(array[i]);
        }
    }
    /*
    * 数组删除元素*/
    public int  delete(int index) throws Exception{
        //判断下标是否越界
        if (index<0||index>size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");
        }
        int indexdeleteelement = array[index];
        //从左到右循环，将元素逐个向左挪一位
        for (int i = index;i < size -1;i++){
            array[i]=array[i+1];
        }
        size--;
        return indexdeleteelement;
    }

    public static void main(String[] args) throws Exception{
        OverInsert mi = new OverInsert(10);
        mi.insert(3,0);
        mi.insert(7,1);
        mi.insert(9,2);
        mi.insert(5,3);
        mi.insert(6,1);
        mi.output();
        mi.delete(2);
        mi.output();
    }

}
