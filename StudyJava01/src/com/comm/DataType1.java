package com.comm;

public class DataType1 {
    //程序由上往下之行的
    //psvm 快捷键 显示main方法
    public static void main(String[] args) {

        /*
        * 01
        * 输出语句与转译字符*/
     //sout 快捷键显示输出方法 输出控制台  严格区分大小写 中英文
        //控制台输出的数据没有换行
        //print()中必须放置数据
        System.out.print("中国");
        System.out.print("美国");

        //println 打印数据的同时换行 学习编程就是为了学习语法
        //println（）可以不放数据
        System.out.println("美国人");
        System.out.println("法国人");

        //两条数据中间换行
        System.out.println("第一条数据换行");
        System.out.println("第二条数据不换行");

        System.out.print("第3条数据换行");
        System.out.println();
        System.out.print("第4条数据不换行");

    }
}
