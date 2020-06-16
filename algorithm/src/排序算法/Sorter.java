package 排序算法;

/**
 * @program: _1
 * @description: 日常复习快排
 * @author: mooncake
 * @create: 2020-06-09 20:08
 **/
public class Sorter implements Runnable{
    @Override
    public void run() {

    }

    public Sorter(){
//        经典排序JAVA实现
    }
    public void sort(int[] arr){
        quickSort(0,arr.length-1,arr);
    }
    public static void main(String args[]){
        Sorter s = new Sorter();
        int[] a = new int[]{5,2,3,1};
        s.sort(a);
        for (int i:a){
            System.out.println(i);
        }
    }
    public void quickSort(int i,int j,int[] arr){
        if (i>=j)return;
        int base = arr[i];
        int low = i;
        int high = j;
        while (low<high){
            while (base<arr[high]){
                high--;
            }
            arr[low]=arr[high];
            arr[high]=base;
            while (base>arr[low]){
                low++;
            }
            arr[high]=arr[low];
            arr[low]=base;
            high--;
        }

        quickSort(i,low,arr);
        if (low==j)return;
        quickSort(low+1,j,arr);


    }
}
