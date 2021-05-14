package com.Serializable;

import java.io.Serializable;

public class User implements Serializable {

    /*
     * JDK 类库中序列化 API
     *使用到JDK中关键类 ObjectOutputStream(对象输出流) 和ObjectInputStream(对象输入流)
     *ObjectOutputStream 类中：通过使用 writeObject(Object object) 方法，将对象以二进制格式进行写入。
     *ObjectInputStream 类中：通过使用 readObject（）方
     * */

    //我们创建一个 User 类，实现 Serializable 接口，并生成一个版本号 ：


    /**
     * 1、Serializable 接口的作用只是用来标识我们这个类是需要进行序列化，并且 Serializable 接口中并没有提供任何方法。
     * 2、SerialVersionUid 序列化版本号的作用是用来区分我们所编写的类的版本，
     * 用于判断反序列化时类的版本是否一直，如果不一致会出现版本不一致异常。
     * 3、transient 关键字，主要用来忽略我们不希望进行序列化的变量
     */

    private static final long serialVersionUID = 3604972003323896788L;
    private transient int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    /*
    *
    * Java 中对象的序列化就是将对象转换成二进制序列，反序列化则是将二进制序列转换成对象。
采用Java序列化与反序列化技术：
一是可以实现数据的持久化，在MVC模式中很是有用；
二是可以对象数据的远程通信。
*
* Java 实现序列化的多种方式
首先需要使用到工具类 ObjectInputStream 和ObjectOutputStream 两个IO类
实现 Serializable 接口
实现 Externalizable 接口
    * */
}