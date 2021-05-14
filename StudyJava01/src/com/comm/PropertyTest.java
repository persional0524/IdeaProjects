package com.comm;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropertyTest {

    public static void main(String[] args) {
        //Properties类继承自Hashtable类并且实现了Map接口，也是使用一种键值对的形式来保存属性集。
        // 不过Properties有特殊的地方，就是它的键和值都是字符串类型。
        Properties prop =new Properties();
        //读取属性文件a.properties

        try {
            InputStream in = new BufferedInputStream(new FileInputStream("a.properties"));
            InputStream in1 = new BufferedInputStream(new FileInputStream("b.properties"));
            prop.load(in);///加载属性列表
            prop.load(in1);///加载属性列表

            /*
              Iterator
            * 迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，而开发人员不需要了解该序列的底层结构。
            * 迭代器通常被称为“轻量级”对象，因为创建它的代价小。

            Java中的Iterator功能比较简单，并且只能单向移动：

　　         (1) 使用方法iterator()要求容器返回一个Iterator。
                第一次调用Iterator的next()方法时，它返回序列的第一个元素。
                注意：iterator()方法是java.lang.Iterable接口,被Collection继承。

　　         (2) 使用next()获得序列中的下一个元素。

　　         (3) 使用hasNext()检查序列中是否还有元素。

　　         (4) 使用remove()将迭代器新返回的元素删除。

　　         Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，
            它可以从两个方向遍历List，也可以从List中插入和删除元素。
            * */
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while (it.hasNext()){
                String key = it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();

            ///保存属性到b.properties文件
            FileOutputStream ofile = new FileOutputStream("b.properties",true);//true表示追加打开
            prop.setProperty("telphone","15031575597");
            prop.setProperty("telphone1","15232346611");
            prop.store(ofile,"the new properties file");
            ofile.close();

            Iterator<String> it1=prop.stringPropertyNames().iterator();
            while (it1.hasNext()){
                String key1 = it1.next();
                System.out.println(key1+":"+prop.getProperty(key1));
            }
            in1.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }
}
