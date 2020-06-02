package other;


class Solution {
    private  int[] arr;
    public int[] sortArray(int[] nums){
        arr=nums;
        quickSort(nums[0],0,nums.length-1);
        return arr;

    }
    public void quickSort(int base,int low,int high){
        if (low>=high)return;
        int begin =low;
        int end = high;
        while(low<high) {

                while (low<high&&base<=arr[high]){
                    high--;
                }
                arr[low]=arr[high];
                arr[high]=base;
                while (low<high&&base>=arr[low]){
                        low++;
                }
                arr[high]=arr[low];
                arr[low]=base;


        }
        quickSort(arr[begin],begin,low-1);
        quickSort(arr[low+1],low+1,end);
    }
    public static void main(String[] args){
        Solution s =new Solution();
        int[] a = s.sortArray(new int[]{7,1,2,5,9,8,3,2,7});
        for (int i:a){
            System.out.println(i);
        }
    }
}