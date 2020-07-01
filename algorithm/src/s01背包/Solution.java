package s01背包;

/**
 * @program: _1
 * @description: 01背包问题
 * @author: mooncake
 * @create: 2020-06-30 21:23
 **/
public class Solution {
    /*
    * w物品重量数组
    * v物品价值数组
    * cap背包容量
    * */
    public int knapsack(int[] w,int[] v,int cap){
        int[][] dp = new int[w.length+1][cap+1];
        for (int i=1;i<dp.length;i++){
            for (int c=1;c<=cap;c++){
                if(w[i-1]>c){
                    dp[i][c]=dp[i-1][c];
                }else {
                    dp[i][c]=Math.max(dp[i-1][c],dp[i-1][c-w[i-1]]+v[i-1]);
                }
            }

        }
        return dp[dp.length-1][20];
    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.knapsack(new int[]{2,3,4,5,9},new int[]{3,4,5,8,10},20));
    }
}
