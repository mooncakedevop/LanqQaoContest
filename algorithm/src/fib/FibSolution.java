package fib;

/**
 * @program: _1
 * @description: 求解斐波那契
 * @author: mooncake
 * @create: 2020-06-10 10:03
 **/
public class FibSolution {
    public int recurFib(int n){
        if (n<=2)return 1;
        return recurFib(n-1)+recurFib(n-2);
    }
    public int dpFib(int n){
        if (n<=2)return 1;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
