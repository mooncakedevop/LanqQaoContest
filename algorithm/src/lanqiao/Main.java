package lanqiao;

import java.util.Scanner;

/**
 * @program: _1
 * @description: 蓝桥杯模板文件
 * @author: mooncake
 * @create: 2020-06-02 09:02
 **/
public class Main {

    public static void main(String args[]){

//        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[length+1];
        long[] map = new long[k];
        for(int i=1;i<=length;i++){
            arr[i]=sc.nextInt()+arr[i-1];
            map[(int)(arr[i]%k)]++;
        }
        long sum=0;
        sum += map[0];
        for (long item:map){
            sum += (item*(item-1))/2;
        }
        System.out.println(sum);


    }
}