package 整数划分;

/**
 * @program: _1
 * @description: 整数划分
 * @author: mooncake
 * @create: 2020-06-30 18:32
 **/
public class Solution {
    public int integerDivide(int n){
        return divide(n,n);
    }
    public int divide(int n,int m){
        if(m==1||n==1)return 1;
        if(n==m)return 1+divide(n,m-1);
        return divide(n,m-1)+divide(n-m,m);
    }
    public static void main(String args[]){
        Solution s =new Solution();
        System.out.println(s.integerDivide(4));
    }
}
