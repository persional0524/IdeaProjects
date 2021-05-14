package com.list;

import java.util.ArrayList;
import java.util.List;

public class Studylist {

    //List<String> list = new ArrayList<String>();
    //list<Stirng> list = Lists.newArrayList();
    //List中添加list
    public static void main(String[] args) {
        List<List<Integer>> vecvecRes = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= 5; j++) {
                list.add(j);
            }
            vecvecRes.add(list);
        }
        for(List<Integer> subList : vecvecRes){
            System.out.println(subList);
        }
    }


}
