import java.net.DatagramPacket;
import java.util.Scanner;

/**
 * @program: _1
 * @description: 机试模板
 * @author: mooncake
 * @create: 2020-07-02 14:41
 * 依旧是字符串处理，设A和B是两个字符串。我们要用最少的字符操作次数，将字符串A转换为字符串B。这里所说的字符操作共有三种：
 *
 * 删除一个字符；
 * 插入一个字符；
 * 将一个字符改为另一个字符。 对任给的两个字符串A和B，计算出将字符串A变换为字符串B所用的最少字符操作次数。
 **/
public class Main{
public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String word =sc.nextLine();
//
//        System.out.println(maxPalindrome(n,word));
        Design d = Design.DESIGN;
        System.out.println(d.hashCode());
   }
   public static  int maxPalindrome(int n,String word){
//        dp[i][j]长度为i,j处分割
    int[] positive = new  int[n];
    int[] negative=new int[n];
    positive[0]=1;
//  positive
    for (int i=1;i<n-1;i++){
        positive[i]=positive[i-1]+1+end(i,word);
    }

    negative[n-1]=0;
//  negative
    for (int i=n-2;i>=0;i--){
        negative[i]=rec(n-i);
    }

    int res = 0;
    for (int i=0;i<n-1;i++){
        res=Math.max(res,positive[i]*negative[i+1]);
    }
    return res;
   }
   static int start(int s,String word){
       int res =0;
       int end=s+1;
       while (end<word.length()){
           if (judge(s,end,word)){
               res++;
           }
           end+=2;
       }
       return res;
   }
   static int end(int i,String word){
    int res =0;
    int start=i-1;
    while (start>=0){
        if (judge(start,i,word)){
            res++;
        }
        start-=2;
    }
    return res;
   }
   static boolean judge(int start,int end,String word){
            while (start>=0&&start<=end){
                if (word.charAt(start)!=word.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
   }
   static int rec(int n){
    if (n==1)return n;
    return n*rec(n-1);
   }
   public static String unfold(int p1,int p2,int p3,String str){

        String[] arr = str.split("-");
        StringBuilder builder = new StringBuilder();
        for (int i=1;i<arr.length;i++){
            if(arr[i].charAt(0)-arr[i-1].charAt(arr[i-1].length()-1)<=0){
                arr[i-1]+= "-";
            }else{
                String tmp = "";
                for (int j=1+(int) arr[i-1].charAt(arr[i-1].length()-1);j<(int)arr[i].charAt(0);j++){
                    tmp += fun2(p1,p2,j);
                }
                if(p3==2)tmp=reverse(tmp);
                arr[i-1]+=tmp;
            }
            builder.append(arr[i-1]);
        }
        builder.append(arr[arr.length-1]);

        return builder.toString();
   }
   static String fun1(int length){
    String res="";
    for (int i=0;i<length;i++){
        res+="*";
    }
    return res;
   }
   static String fun2(int p1,int p2,int j){
    String res = "";
    for (int i=0;i<p2;i++){
        res += (char)j;
    }
    if(p1==1)res=res.toLowerCase();
    if(p1==2)res=res.toUpperCase();
    if(p1==3)res=fun1(res.length());
    return res;
   }
   public static boolean match(String pattern,String word){
        return word.matches(pattern);
   }
   public static String reverse(String word){
    StringBuilder builder = new StringBuilder();
    for (int i=word.length()-1;i>=0;i--){
        builder.append(String.valueOf(word.charAt(i)));
    }
    return builder.toString();
   }
   public static void  Test1(String word1,String word2){
       if (word1==null||word1.length()==0){
           System.out.println(word2.length());
           return;
       }
       if(word2==null||word2.length()==0){
           System.out.println(word1.length());
           return;
       }
       int[][] dp = new int[word1.length()+1][word2.length()+1];
       dp[0][0] = 0;
       for (int i=1;i<dp[0].length;i++){
           dp[0][i]=i;
       }
       for (int i=1;i<dp.length;i++){
           dp[i][0]=i;
       }
       for (int i=1;i<=word1.length();i++){
           for (int j=1;j<=word2.length();j++){
               if (word1.charAt(i-1)==word2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1];
               }else {
                   dp[i][j]=Math.min(Math.min(1+dp[i-1][j],1+dp[i][j-1]),1+dp[i-1][j-1]);
               }
           }
       }
       System.out.println(dp[word1.length()][word2.length()]);
   }
   public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}