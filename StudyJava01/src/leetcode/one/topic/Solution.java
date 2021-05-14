package leetcode.one.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liutao0705@live.com
 * @date 2019/12/17 5:06 下午
 */

/*
两数之和
*/

/*
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
* */

//方法一：暴力法
//

public class Solution {

   public  int[] twosum(int[] nums, int target){

       for (int i = 0; i <nums.length ; i++) {
           for (int j = i + 1; j < nums.length; j++) {
             if(nums[j] == target - nums[i]){
                 //没有void 需要有renturn
                 return new int[] {i,j};
             }
           }
       }
       //IllegalArgumentException不合法的参数异常
       throw new IllegalArgumentException("no two sum solition");
   }

   public String gets(){
       String s = "asdasd";
       return s;
   }
    public  int[] twosum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
     //有序数组，不能重复
//     int[] Twosum = {1,2,3,4,5,6};
//     int target = 9;
//
//        for (int i = 0; i <Twosum.length ; i++) {
//            for (int j = Twosum.length -1 ; j <Twosum.length ; j--) {
//
//                System.out.println("Twosum.length -1="+j);
//                int Sum =Twosum[i] + Twosum[j];
//
//                if( Sum == target ){
//                    System.out.println("<"+i+j);
//                    break;
//                }
//            }
//        }

        //没有static 所有需要实例化
        int [] arrayA = new int []{1,2,7,8,11,15};
        Solution sl = new Solution();

        //sl.twosum(arrayA,9);
        sl.twosum2(arrayA,9);
        //sl.gets();

        //System.out.println(sl.twosum(arrayA,9));
        System.out.println(sl.twosum2(arrayA,9));
        //System.out.println(sl.gets());
        //数组迭代
        for(int subList : sl.twosum2(arrayA,9)){
            System.out.println(subList);
        }
    }


}
