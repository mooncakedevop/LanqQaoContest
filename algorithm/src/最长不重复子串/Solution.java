package 最长不重复子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: _1
 * @description:
 * @author: mooncake
 * @create: 2020-07-04 11:17
 **/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        if(s.length()==1)return 1;
        int i=0,j=1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int res=1;
        while(j<s.length()){
            if(set.add(s.charAt(j))){
                res = Math.max(res,set.size());
            }else{
                res = Math.max(res,set.size());
                int newStart = s.indexOf(s.charAt(j),i);
                for (int k=i;k<newStart;k++){
                    set.remove(s.charAt(k));
                }
                i=newStart+1;

            }
            j++;
        }
        return res;
    }
    public static void main(String args[]){
        Solution s =new Solution();
        s.lengthOfLongestSubstring("aabaab!");
    }
}