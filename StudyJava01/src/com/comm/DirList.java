package com.comm;

import java.io.File;

public class DirList {

    /*
    * 读取目录
一个目录其实就是一个 File 对象，它包含其他文件和文件夹。

如果创建一个 File 对象并且它是一个目录，那么调用 isDirectory() 方法会返回 true。

可以通过调用该对象上的 list() 方法，来提取它包含的文件和文件夹的列表。

下面展示的例子说明如何使用 list() 方法来检查一个文件夹中包含的内容：
    * */
    public static void main(String[] args) {
        String dirname="/Users/liutao/Downloads";
        File f1 = new File(dirname);
        if (f1.isDirectory()){
            System.out.println("mac本地下载目录为"+dirname);
            String s[] =f1.list();
            for (int i = 0;i < s.length;i++){
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        }else {
            System.out.println(dirname + " 不是一个目录");
        }
    }
}
