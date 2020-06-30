package 归并排序;

/**
 * @program: _1
 * @description: 归并排序
 * @author: mooncake
 * @create: 2020-06-30 17:45
 **/
class Solution {
    public int[] sortArray(int[] nums){

        partion(0,nums.length-1,nums);
        return nums;

    }

    public void partion(int l,int r,int[] nums){
        if(r==l)return;
        int mid= (r+l)/2;
        partion(l,mid,nums);
        partion(mid+1,r,nums);
        merge(l,mid-l+1,r-mid,nums);

    }
    public void merge(int index,int m,int n,int[] nums){
        int[] temp=new int[m+n];
        int i=0,j=0;
        for(int k=0;k<temp.length;k++){
            if(j==n||(i<m&&nums[index+i]<=nums[index+m+j])){
                temp[k]=nums[index+i++];
            }else if(i==m||(j<n&&nums[index+m+j]<=nums[index+i])){
                temp[k]=nums[index+m+j++];
            }
        }
        for(int k=0;k<temp.length;k++){
            nums[index+k]=temp[k];
        }
    }
    public static void main(String args[]){
        Solution s = new Solution();
        s.sortArray(new int[]{5,2,3,1});
    }
}
