package 每日温度;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: _1
 * @description: 力扣每日一题
 * @author: mooncake
 * @create: 2020-06-11 08:36
 **/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{0,T[0]});
        int min=T[0];
        for(int i=1;i<T.length;i++){
            if(T[i]>min){
//              变为当前值
                int[] base = queue.peek();
                while (!queue.isEmpty()){
                    if(T[i]>base[1]){
                        queue.poll();
                        res[base[0]]=i-base[0];
                        base= queue.peek();
                    }else {
                        break;
                    }
                }


            }
            min=T[i];
            queue.add(new int[]{i,T[i]});


        }
        return res;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        for(int i:s.dailyTemperatures(new int[]{
                55,38,53
        })){
            System.out.println(i);
        }
    }
}