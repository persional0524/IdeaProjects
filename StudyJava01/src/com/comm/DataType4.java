package com.comm;

public class DataType4 {
    public static void main(String[] args) {
        /*01
        * 数字类型
        * */


        //数据类型 变量名 = 值
        //short 占两个字节（-32768～32767）
        short s1 = 12;
        int a = 10;

        System.out.println(s1);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        //int 占四个字节 (-2147483648~2147483647)
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


        //long 占八个字节 (-9223372036854775808~9223372036854775807)
        //long 变量名 = 整数L
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        Long A1 = 9223372036854775807L;
        System.out.println(A1);

        System.out.println("----------小数--------");

        /*011
         * 数字类型
         * 小数
         * */
         //float 占四个字节
         //float 变量名 = 小数F; 精确到小数点后7位
         //F可以小写 规范大写
         float  fa = 3.14F;
         float  fb = 3.123456789F;
         System.out.println(fa);
         System.out.println(fb);

         //double 占8个字节
         //double 变量名 = 小数； 精确到小数点后15位
         double da = 3.123456789;
         double db = 3.123456789123456789;
         System.out.println(da);
         System.out.println(db);


        /*02
         * 字符
         * */
        System.out.println("----------字符语法--------");
        //----------字符语法--------
        //----------char 占两个字节  一个汉子占用两个字节
        //char 变量名 = '值'；

        char ch1 ='中';
        char ch2 ='¥';
        char ch3 ='a';
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
    }
}
