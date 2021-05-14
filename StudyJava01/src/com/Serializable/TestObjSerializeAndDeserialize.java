package com.Serializable;


import java.io.*;
import java.text.MessageFormat;

//对象的序列化是与平台无关的，因此在一个平台上被“序列化”的对象可以很容易的在另一个不相同的平台上给“反序列化”出来。

/**
 * <p>Description: 测试对象的序列化和反序列<p>
 * <p>Description: 序列化和反序列化Person类对象<p>
 */
public class TestObjSerializeAndDeserialize {

    //SerializePerson();//序列化Person对象
    //Person p = DeserializePerson();//反序列Perons对象
        //System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(), p.getAge(), p.getSex()));}

    /**
     * Description: 序列化Person对象
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("男");
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * Description: 反序列Perons对象
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}
